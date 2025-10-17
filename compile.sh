#!/bin/bash
set -e

# === Dossiers ===
SRC="src/main/java"
LIB="lib"
OUT="build/classes"

# === Création du dossier de sortie ===
mkdir -p "$OUT"

# === Compilation de tout le projet ===
echo "🔧 Compilation de toutes les classes Java ..."
find "$SRC" -name "*.java" > sources.txt
javac -encoding UTF-8 -cp "$LIB/*" -d "$OUT" @sources.txt

echo "✅ Compilation terminée avec succès."


# java -cp "build/classes:lib/*" app.Main (execution)
