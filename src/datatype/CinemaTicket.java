package datatype;

import java.util.Arrays;
import java.util.Scanner;

public class CinemaTicket {
    public static void print(int[][] seats) {
        for (int[] row : seats)
            System.out.println(Arrays.toString(row) + " ");
    }

    public static void main(String[] args) {
        int[][] seats = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};
        String[] movies = {"Home Alone", "Interstellar", "Cinderalla"};
        System.out.println("welcome to our cinema:)");
        System.out.println("names of movies that we have in cinema:");
        for (String name : movies) {
            System.out.println(name);
        }

        System.out.println("choose movie you want:");
        Scanner sc = new Scanner(System.in);
        String movie = sc.nextLine();
        boolean check = false;
        for (String name : movies) {
            if (movie.equalsIgnoreCase(name)) {
                System.out.println("available seat numbers:");
                print(seats);
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("movie is not available");
            return;
        }


        while (true) {
            System.out.println("Choose the seat number you want:");
            int seat = sc.nextInt();
            boolean seatFound = false;
            for(int i=0;i<seats.length;i++) {
                for(int j=0;j<seats[i].length;j++) {
                    if (seats[i][j] == seat) {
                        seats[i][j] = 0;
                        seatFound = true;
                        break;
                    }
                }
            }

            if(seatFound) {
                System.out.println("Seat booked successfully. Updated seat arrangement:");
                print(seats);
            }
            else {
                System.out.println("Seat not available or already booked. Please choose another seat.");
            }


        }












    }
}










