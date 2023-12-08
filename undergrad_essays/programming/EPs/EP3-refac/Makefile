CC = gcc
CFLAGS = -Wall -Wextra -std=c99
LDFLAGS = -lm
SRC_DIR = src
OBJ_DIR = obj

# List of source files
SRCS = $(wildcard $(SRC_DIR)/*.c)

# List of object files
OBJS = $(patsubst $(SRC_DIR)/%.c, $(OBJ_DIR)/%.o, $(SRCS))

# Executable name
EXEC = main

.PHONY: all clean run

all: $(EXEC)

$(EXEC): $(OBJS)
	$(CC) $(CFLAGS) $^ -o $@ $(LDFLAGS)

$(OBJ_DIR)/%.o: $(SRC_DIR)/%.c
	$(CC) $(CFLAGS) -c $< -o $@

clean:
	rm -rf $(OBJ_DIR)/*.o $(EXEC)

run: all
	./$(EXEC)