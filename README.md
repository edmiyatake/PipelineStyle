# TopWordFrequency Program - Pipeline Style

## Overview
--------
The `Six` program is a Pipeline-style Java application that:

Reads a text file to analyze.
- Normalizes the characters by removing punctuation and converting to lowercase.
- Splits the cleaned text into individual words.
- Removes stop words (common, uninformative words).
- Counts the frequency of each remaining word.
- Sorts the words by frequency in descending order.
- Prints the top 25 most frequent words.e.

This version uses a modular, function-based pipeline structure, where each transformation step is defined in a separate method and passed through sequentially, resembling Unix-style command chaining.

## Constraints
--------
- No long jumps.
- Complexity of control flow tamed by dividing the large problem into
smaller units using procedural abstraction. Procedures are pieces of functionality that may take input, but that don’t necessarily produce output
that is relevant for the problem.
- Procedures may share state in the form of global variables.
- The larger problem is solved by applying the procedures, one after the
other, that change, or add to, the shared state.

## Project Folder Structure
------------------------
Place the following files in the same folder:

- Six.java           // The Java source code file
- test.txt            // Input text files to be analyzed
- stopwords.txt       // File containing comma-separated stop words

Example stopwords.txt:
a,an,the,in,of,to,for,with,is,was,and,by,on,from,at

## How to Compile and Run
-----------------------

1. Open Command Prompt or Terminal

2. Navigate to the source folder where the Java file and text files are located.

   Example:
   cd path\to\your\folder
   (replace with actual path)

3. Compile the program:
   javac Four.java

4. Run the program:
   java Four test.txt stopwords.txt

The program will output the top 25 most frequent words in the file, excluding stopwords.

## Expected Output Example
------------------------
Top 25 words:
love: 123

elizabeth: 87

darcy: 79

mr: 75

time: 63

...

## NOTES
-----
- This implementation uses Java's built-in libraries (`java.util.*`, `java.nio.file.*`) for list, map, and file operations.
- The program recursively prints the word frequencies using a helper method.
- The `stopwords.txt` file must be in the same directory as the program and should contain stop words separated by commas.
- The program automatically ignores all single-letter words (a-z) as part of the stop words list.
- Clean modular structure makes this version easier to extend or refactor.
