#!/bin/bash
# Exit immediately if any command fails
set -e

# Check if directory argument is provided
if [ -z "$1" ]; then
  echo "Usage: $0 /d/Revature_Training/01-linux/Challenges/test-files"
  exit 1
fi

DIR="$1"

# Check if the provided directory exists
if [ ! -d "$DIR" ]; then
  echo "Error: Directory does not exist"
  exit 1
fi

# Declare an associative array to count file types
declare -A COUNT

# Loop through all files in the directory
for file in "$DIR"/*; do
  # Skip if not a regular file
  [ -f "$file" ] || continue

  # Extract file extension
  ext="${file##*.}"

  # Handle files without an extension
  if [[ "$file" != *.* ]]; then
    ext="no_extension"
  fi

  # Create directory for the extension if it doesn't exist
  mkdir -p "$DIR/$ext"

  # Move file into corresponding directory
  mv "$file" "$DIR/$ext/"

  # Increment count
  ((COUNT[$ext]++))
done

# Print summary
echo "Summary:"
for ext in "${!COUNT[@]}"; do
  echo "Organized ${COUNT[$ext]} .$ext files"
done
