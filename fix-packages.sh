#!/bin/bash

src_dir="src/main/kotlin"

# Najdi všechny .kt soubory
find "$src_dir" -name "*.kt" | while read -r file; do
    # Najdi řádek s deklarací package
    package_line=$(grep "^package " "$file")

    if [[ -n "$package_line" ]]; then
        # Vezmi pouze jméno balíčku
        package_name=${package_line#"package "}
        # Nahraď tečky lomítky
        package_path=$(echo "$package_name" | tr '.' '/')
        # Cílová složka
        target_dir="$src_dir/$package_path"
        mkdir -p "$target_dir"

        # Přesuň soubor
        mv "$file" "$target_dir/"
        echo "Moved $file → $target_dir/"
    else
        echo "No package declaration found in $file"
    fi
done
