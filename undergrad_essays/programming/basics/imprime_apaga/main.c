#include <stdio.h>
#include <unistd.h>

#define MAX_ROWS 10
#define MAX_COLS 10

int main() {
    // Define a 10x10 grid of characters
    char grid[MAX_COLS][MAX_ROWS] = {
        "123456789",
        "abcdefghi",
        "JKLMNOPQR",
        "jklmnopqr",
        "STUVWXYZ0",
        "stuvwxyz1",
        "@#$%^&*()",
        "23456789-",
        "+={};:'\",",
        "</>?.!_`~ "
    };

    // Print the 10x10 grid
    for (int i = 0; i < MAX_ROWS; ++i) {
        for (int j = 0; j < MAX_COLS; ++j) {
            printf("%c", grid[i][j]);
        }
        
        printf("\n");
    }

    sleep(3);

    // Move to the beginning of the next line
    for(int i=0; i<MAX_ROWS; ++i) {
        printf("\r");

        // Move the cursor up by 1 position
        printf("\033[1A");

        for (int j = 0; j < MAX_COLS; ++j) {
            printf(" ");
        }
    }

    for (int j = 0; j < MAX_COLS; ++j) {
        printf("\b");
    }

    return 0;
}
