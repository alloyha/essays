#include <stdio.h>
#include <unistd.h>

#define MAX_ROWS 10
#define MAX_COLS 10

void apagar_bloco(int n_linhas, int n_colunas) {
    // Move to the beginning of the next line
    for(int i=0; i<n_linhas; ++i) {
        printf("\r");

        // Move the cursor up by 1 position
        printf("\033[1A");

        for (int j = 0; j < n_colunas; ++j) {
            printf(" ");
        }
    }

    for (int j = 0; j < MAX_COLS; ++j) {
        printf("\b");
    }
}

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

    apagar_bloco(MAX_COLS, MAX_ROWS);    

    return 0;
}
