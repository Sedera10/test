#!/bin/bash
set -e  # Stoppe le script si une erreur se produit

# === Chemins ===
SRC="src/main/java"
WEBAPP="src/main/webapp"
RESOURCES="src/main/resources"
OUT="build"
LIB="lib"
WAR_NAME="Sprint.war"
DEST_DIR="/home/sedera/Documents/apache-tomcat-10.1.28/webapps"

# === Création du dossier de sortie ===
mkdir -p "$OUT"

# === Construction de la liste des fichiers Java ===
echo "Création de la liste des sources Java..."
find "$SRC" -name "*.java" > sources.txt

# === Compilation ===
echo "Compilation des fichiers Java..."
javac -encoding UTF-8 --release 23 -cp "$LIB/*" -d "$OUT/WEB-INF/classes" @sources.txt

echo "✅ Compilation réussie."

# === Copie des fichiers web ===
echo "Copie des fichiers web..."
mkdir -p "$OUT"
cp -r "$WEBAPP"/* "$OUT"/

# === Copie des fichiers de ressources ===
if [ -d "$RESOURCES" ]; then
    echo "Copie des fichiers de ressources..."
    mkdir -p "$OUT/WEB-INF/classes"
    cp -r "$RESOURCES"/* "$OUT/WEB-INF/classes"/
else
    echo "⚠️  Attention : le dossier de ressources '$RESOURCES' n'existe pas !"
fi

# === Copie des bibliothèques ===
echo "Copie des bibliothèques..."
mkdir -p "$OUT/WEB-INF/lib"
cp "$LIB"/*.jar "$OUT/WEB-INF/lib/" 2>/dev/null || true

# === Création du fichier WAR ===
echo "Création du fichier WAR..."
cd "$OUT"
jar -cvf "../$WAR_NAME" *
cd ..

echo "✅ WAR généré avec succès : $WAR_NAME"

# === Déploiement automatique ===
if [ -d "$DEST_DIR" ]; then
    echo "Copie de $WAR_NAME vers $DEST_DIR ..."
    cp -f "$WAR_NAME" "$DEST_DIR/$WAR_NAME"
    echo "🚀 Déploiement réussi."
else
    echo "⚠️  Le répertoire de déploiement '$DEST_DIR' n'existe pas."
fi
