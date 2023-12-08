# README

## Project Compilation Instructions

This project is organized using a Makefile for convenient compilation. Follow the steps below to compile and run the project using the provided Makefile.

### Prerequisites

Make sure you have the GCC (GNU Compiler Collection) installed on your system. If not, you can install it by following the instructions for your operating system.

### Compilation Steps

1. **Compile and Link the Project:**

```bash
make
```

This command will compile the project and create an executable named `main`. The compilation process is defined in the Makefile.

### Run the Executable

After successfully compiling the project, you can run the executable file:

```bash
./main
```

## Clean Up

To remove the compiled object files and the executable, you can use the following command:

```bash
make clean
```

## Additional Notes

- Ensure that all source files (.c and .h) are correctly named and placed in the appropriate directories.
- Review the Makefile for any customization needed based on your project structure.
- If you encounter any issues during the compilation process, review the error messages and consult the relevant documentation or seek assistance from your development community.

By using the provided Makefile, you can streamline the compilation process and manage the build of your project more efficiently.