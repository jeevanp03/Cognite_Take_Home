## T9 Texting Project README

### Overview

This project recreates the T9 (Text on 9 keys) predictive text input system, reminiscent of the late 1990s cell phone technology. Users input a sequence of numbers corresponding to a standard 12-key phone dialpad, and the system generates possible word combinations. This project includes the implementation of a `CodeConversion` class, a functional interface for word checking, and a `T9Texting` class that integrates all components to find valid words from a given numeric sequence.

### Implementation Details

#### CodeConversion Class

- **Location:** `T9Texting/src/main/java`
- **Purpose:** Generates all possible letter combinations for a given sequence of digits using a mapping of digits to letters.
- **Core Methods:**
  - `generateCombinations`: Recursively generates letter combinations for the input sequence.
  - Accessor methods for `code` and `map` fields.

#### Interfaces

- **Location:** `T9Texting/src/main/java`
- **Purpose:** Contains functional interfaces used in the project.
- **Key Interfaces:**
  - `WordChecker`: A functional interface with a single method `isWord`, used to determine if a string constitutes a valid word.

#### T9Texting Class

- **Location:** `T9Texting/src/main/java`
- **Functionality:** Serves as the entry point of the application. It simulates a T9 texting environment where users input a sequence of digits, and the system outputs all valid words as per a stubbed dictionary.
- **Key Components:**
  - `main`: Initializes a stubbed dictionary and the digit-to-letter map, then finds and prints valid words for a given numeric sequence.
  - `findWords`: Uses `CodeConversion` to generate all possible combinations and then filters them based on validity using the provided dictionary.

### How to Use

1. **Setup:** Ensure Java is installed and configured on your system.
2. **Compilation:** Navigate to the project directory and compile the Java files. For example, using `javac T9Texting/src/main/*.java`.
3. **Execution:** Run the `T9Texting` class. For example, `java T9Texting/src/main/T9Texting`.
4. **Input:** The `main` method in `T9Texting` class currently uses a hardcoded input sequence (`4663`). Modify this as needed to test different inputs.

### Testing

#### Main Function Output
The project includes a basic stubbed dictionary for testing purposes, which considers a word valid if its length is even. For more comprehensive testing, integrate a more complex dictionary or word-checking mechanism.

#### JUnit Tests
- **Location:** `T9Texting/src/testing/java`
There are 2 JUnit testing files under this directory: `TestCodeConversion` and `TestT9Texting`.

##### TestCodeConversion
- **Functionality:** Tests the object I created to make sure fields are updated correctly and the object's method's output is correct.

#### TestT9Texting
- **Functionality:** Tests the `findWords` functions to make sure the output is correct given the parameters in the problem statement provided.



