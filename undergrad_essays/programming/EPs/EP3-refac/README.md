# README

## Project Compilation Instructions

This project consists of several source files that need to be compiled and linked together to create an executable file. Follow the steps below to compile the project using the GCC compiler.

### Prerequisites

Make sure you have the GCC (GNU Compiler Collection) installed on your system. If not, you can install it by following the instructions for your operating system.

### Compilation Steps

1. **Compile main.c:**
    ```bash
    gcc -c main.c -o main.o
    ```

2. **Compile utils.c:**
    ```bash
    gcc -c utils.c -o utils.o
    ```

3. **Compile physics.c:**
    ```bash
    gcc -c physics.c -o physics.o
    ```

4. **Link Object Files:**
    ```bash
    gcc main.o physics.o utils.o -o main -lm
    ```

    Note: The `-lm` flag is used to link the math library. If your project doesn't involve math functions, you can omit this flag.

### Run the Executable

After successfully compiling the project, you can run the executable file:

```bash
./main
```

## Additional Notes

- Ensure that all header files (.h) are included in the corresponding source files (.c).
- Check for any missing or incorrectly implemented functions in the source files.
- Verify that the file extensions (.c, .h) are correct and consistent.

If you encounter any issues during the compilation process, review the error messages and consult the relevant documentation or seek assistance from your development community.
