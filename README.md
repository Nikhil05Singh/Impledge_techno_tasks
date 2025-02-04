Below is a sample `README.md` file for your GitHub repository. This file provides an overview of the project, instructions for setting it up, and details about how to run the code.

---

# Compounded Words Finder

This Java program identifies the longest and second longest compounded words from a sorted list of words. A compounded word is one that can be constructed by concatenating shorter words also found in the same list.

## Features
- Efficiently processes large word lists (100,000+ items).
- Uses a **Trie** data structure for fast prefix searching.
- Implements **dynamic programming** with memoization to optimize performance.
- Outputs the longest and second longest compounded words along with the processing time.

## Input Files
The program reads two input files:
1. `Input_01.txt`: A small word list for testing.
2. `Input_02.txt`: A large word list with 100,000+ items.

Each file contains a list of alphabetically sorted words, one word per line, in lowercase and without spaces.

## Output
For each input file, the program outputs:
1. The longest compounded word.
2. The second longest compounded word.
3. The time taken to process the file.

## Requirements
- Java Development Kit (JDK) 8 or later.
- A text editor or IDE (e.g., IntelliJ IDEA, Eclipse, VS Code).

---

## How to Run the Code

### Step 1: Clone the Repository
Clone this repository to your local machine:
```bash
git clone https://github.com/Nikhil05Singh/Impledge_techno_tasks.git
cd compounded-words-finder
```

### Step 2: Prepare Input Files
Ensure the input files (`Input_01.txt` and `Input_02.txt`) are placed in the root directory of the project. You can use the sample files provided in the repository or create your own.

### Step 3: Compile the Code
Compile the Java program using the following command:
```bash
javac CompoundedWords.java
```

### Step 4: Run the Program
Run the compiled program:
```bash
java CompoundedWords
```

### Step 5: View the Output
The program will process the input files and display the results in the terminal. For example:
```
Processing Input_01.txt:
Longest Compound Word: ratcatdogcat
Second Longest Compound Word: catsdogcats
Time taken to process file Input_01.txt: 2 milliseconds

Processing Input_02.txt:
Longest Compound Word: ethylenediaminetetraacetates
Second Longest Compound Word: electroencephalographically
Time taken to process file Input_02.txt: 8000 milliseconds
```

---

## Code Structure
- `CompoundedWords.java`: The main Java program.
- `Input_01.txt`: A small word list for testing.
- `Input_02.txt`: A large word list with 100,000+ items.

---

## Algorithm
1. **Trie Data Structure**:
   - Words are inserted into a Trie for efficient prefix searching.
2. **Dynamic Programming**:
   - A memoization technique is used to avoid redundant checks when determining if a word is compounded.
3. **Sorting**:
   - Words are processed in order of increasing length to ensure smaller words are available for compounding checks.

---

## Performance
The program is optimized for large inputs:
- Time Complexity: Approximately **O(N * L)**, where **N** is the number of words and **L** is the average length of the words.
- Space Complexity: **O(N * L)** for storing the Trie.

---

## Example Input and Output

### Input_01.txt
```
cat
cats
catsdogcats
catxdogcatsrat
dog
dogcatsdog
hippopotamuses
rat
ratcatdogcat
```

### Output for Input_01.txt
```
Processing Input_01.txt:
Longest Compound Word: ratcatdogcat
Second Longest Compound Word: catsdogcats
Time taken to process file Input_01.txt: 2 milliseconds
```

---

## Contributing
Contributions are welcome! If you find any issues or have suggestions for improvement, please open an issue or submit a pull request.

---

## Author
Nikhil Singh
GitHub Profile:- https://github.com/Nikhil05Singh

---
