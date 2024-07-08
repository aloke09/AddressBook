package AddressBook;

import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc=new Scanner(System.in);
        methods m=new methods();
        while(true)
        {
            System.out.println("operations on " +
                    "1. DB" +
                    "2. MAP");
            int op=sc.nextInt();
            switch(op)
            {
                case 1:
                    System.out.println("1. Insert" +
                            "2. Update" +
                            "3. Delete" +
                            "4. Display");
                    int db=sc.nextInt();
                    switch(db)
                    {
                        case 1:
                            m.AddToDB();
                            break;
                        case 2:
                            m.UpdateContactFromDB();
                            break;
                        case 3:
                            m.DelFromDB();
                            break;
                        case 4:
                            m.DispalyAllFromDB();
                            break;
                        default:
                            System.out.println("select a valid DB Operation");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("0. Display all Contact in Address Book-");
                    System.out.println("1. Add a new Contact to Address Book-");
                    System.out.println("2. Edit Contact by there name-");
                    System.out.println("3. Delete Contact by there name-");
                    System.out.println("4. Add multiple Contact to Address Book");
//            System.out.println("5. refactor");//done
//            System.out.println("6. no duplicate");//no1
                    System.out.println("5. Search person details in city/state");
                    System.out.println("6. All Contact in city/state");
                    System.out.println("7. Get Count of Contact by city/state");
                    System.out.println("8. Store it in a simple text file ");
                    System.out.println("9. Store it in a CSV text file ");
                    System.out.println("10. Store it in a json text file ");
                    System.out.println("11. sort");
                    System.out.println("Enter your choice");
                    int choice=sc.nextInt();
                    switch (choice)
                    {
                        case 0:
                            m.displayAll();
                            break;
                        case 1:
                            m.addContact();
                            break;
                        case 2:
                            System.out.println("Enter first name:-");
                            String fName=sc.next();
                            m.editContact(fName);
                            break;
                        case 3:
                            System.out.println("Enter first name");
                            String fName3=sc.next();
                            m.delContact(fName3);
                            break;
                        case 4:
                            System.out.println("Enter how many contact you want to add");
                            int n=sc.nextInt();
                            m.addMultiple(n);
                            break;
                        case 5:
                            System.out.println("Enter First Name-");
                            String name7=sc.next();
                            if(m.choiceCityState())
                            {
                                System.out.println("Enter city-");
                                String city7=sc.next();
                                m.PersonInCity(name7,city7);
                            }
                            else {
                                System.out.println("Enter state-");
                                String state7=sc.next();
                                m.PersonInCity(name7,state7);
                            }
                            break;
                        case 6:
                            System.out.println("Press 1 for CITY\nPress 2 for State");
                            int c8=sc.nextInt();
                            switch (c8)
                            {
                                case 1:
                                    System.out.println("Enter the name of city-");
                                    String city8=sc.next();
                                    m.AllContactInACity(city8);
                                    break;
                                case 2:
                                    System.out.println("Enter the name of state-");
                                    String state8=sc.next();
                                    m.AllContactInAState(state8);
                                    break;
                                default:
                                    System.out.println("Incorrect choice!!\nTRY AGAIN!!");
                                    break;
                            }
                            break;
                        case 7:
                            //Get Count of Contact by city/state
                            System.out.println("Press 1 for CITY\nPress 2 for State");
                            int c9=sc.nextInt();
                            switch (c9)
                            {
                                case 1:
                                    System.out.println("Enter the name of city-");
                                    String city9=sc.next();
                                    m.ContactCountByCity(city9);
                                    break;
                                case 2:
                                    System.out.println("Enter the name of state-");
                                    String state9=sc.next();
                                    m.AllContactInAState(state9);
                                    break;
                                default:
                                    System.out.println("Incorrect choice!!\nTRY AGAIN!!");
                                    break;
                            }
                            break;
                        case 8:
                            System.out.println("Enter 1 to write into Simple file and 2 to read from Simple file-");
                            int c10=sc.nextInt();
                            if(c10==1)
                            {
                                m.writeToFile();
                            }
                            else if (c10==2)
                            {
                                m.readFromFile();
                            }
                            else {
                                System.out.println("Enter a valid input");
                            }
                            break;
                        case 9:
                            System.out.println("Enter 1 to write into CSV file and 2 to read from CSV file-");
                            int c11=sc.nextInt();
                            if(c11==1)
                            {
                                m.WriteToCSV();
                            }
                            else if (c11==2)
                            {
                                m.readFromCSVFile();
                            }
                            else {
                                System.out.println("Enter a valid input");
                            }
                            break;
                        case 10:
                            System.out.println("Enter 1 to write into json file and 2 to read from json file-");
                            int c12=sc.nextInt();
                            break;
                        case 11:
                            System.out.println("Enter sort by" +
                                    "1. FirstName" +
                                    "2. City" +
                                    "3. State" +
                                    "4. Zip");
                            int c13=sc.nextInt();
                            switch (c13)
                            {
                                case 1:
                                    m.SortByName();
                                    break;
                                case 2:
                                    m.SortByCity();
                                    break;
                                case 3:
                                    m.SortByState();
                                    break;
                                case 4:
                                    m.SortByZIP();
                                    break;
                                default:
                                    System.out.println("invalid choice!!");
                                    break;
                            }
                            break;
                        default:
                            System.exit(0);
                    }
                    break;
                default:
                    System.exit(0);
                    break;
            }

        }
//        while(true)
//        {
//            System.out.println("0. Display all Contact in Address Book-");
//            System.out.println("1. Add a new Contact to Address Book-");
//            System.out.println("2. Edit Contact by there name-");
//            System.out.println("3. Delete Contact by there name-");
//            System.out.println("4. Add multiple Contact to Address Book");
////            System.out.println("5. refactor");//done
////            System.out.println("6. no duplicate");//no1
//            System.out.println("5. Search person details in city/state");
//            System.out.println("6. All Contact in city/state");
//            System.out.println("7. Get Count of Contact by city/state");
//            System.out.println("8. Store it in a simple text file ");
//            System.out.println("9. Store it in a CSV text file ");
//            System.out.println("10. Store it in a json text file ");
//            System.out.println("11. sort");
//            System.out.println("Enter your choice");
//            int choice=sc.nextInt();
//            switch (choice)
//            {
//                case 0:
//                    m.displayAll();
//                    break;
//                case 1:
//                    m.addContact();
//                    break;
//                case 2:
//                    System.out.println("Enter first name:-");
//                    String fName=sc.next();
//                    m.editContact(fName);
//                    break;
//                case 3:
//                    System.out.println("Enter first name");
//                    String fName3=sc.next();
//                    m.delContact(fName3);
//                    break;
//                case 4:
//                    System.out.println("Enter how many contact you want to add");
//                    int n=sc.nextInt();
//                    m.addMultiple(n);
//                    break;
//                case 5:
//                    System.out.println("Enter First Name-");
//                    String name7=sc.next();
//                    if(m.choiceCityState())
//                    {
//                        System.out.println("Enter city-");
//                        String city7=sc.next();
//                        m.PersonInCity(name7,city7);
//                    }
//                    else {
//                        System.out.println("Enter state-");
//                        String state7=sc.next();
//                        m.PersonInCity(name7,state7);
//                    }
//                    break;
//                case 6:
//                    System.out.println("Press 1 for CITY\nPress 2 for State");
//                    int c8=sc.nextInt();
//                    switch (c8)
//                    {
//                        case 1:
//                            System.out.println("Enter the name of city-");
//                            String city8=sc.next();
//                            m.AllContactInACity(city8);
//                            break;
//                        case 2:
//                            System.out.println("Enter the name of state-");
//                            String state8=sc.next();
//                            m.AllContactInAState(state8);
//                            break;
//                        default:
//                            System.out.println("Incorrect choice!!\nTRY AGAIN!!");
//                            break;
//                    }
//                    break;
//                case 7:
//                    //Get Count of Contact by city/state
//                    System.out.println("Press 1 for CITY\nPress 2 for State");
//                    int c9=sc.nextInt();
//                    switch (c9)
//                    {
//                        case 1:
//                            System.out.println("Enter the name of city-");
//                            String city9=sc.next();
//                            m.ContactCountByCity(city9);
//                            break;
//                        case 2:
//                            System.out.println("Enter the name of state-");
//                            String state9=sc.next();
//                            m.AllContactInAState(state9);
//                            break;
//                        default:
//                            System.out.println("Incorrect choice!!\nTRY AGAIN!!");
//                            break;
//                    }
//                    break;
//                case 8:
//                    System.out.println("Enter 1 to write into Simple file and 2 to read from Simple file-");
//                    int c10=sc.nextInt();
//                    if(c10==1)
//                    {
//                        m.writeToFile();
//                    }
//                    else if (c10==2)
//                    {
//                        m.readFromFile();
//                    }
//                    else {
//                        System.out.println("Enter a valid input");
//                    }
//                    break;
//                case 9:
//                    System.out.println("Enter 1 to write into CSV file and 2 to read from CSV file-");
//                    int c11=sc.nextInt();
//                    if(c11==1)
//                    {
//                        m.WriteToCSV();
//                    }
//                    else if (c11==2)
//                    {
//                        m.readFromCSVFile();
//                    }
//                    else {
//                        System.out.println("Enter a valid input");
//                    }
//                    break;
//                case 10:
//                    System.out.println("Enter 1 to write into json file and 2 to read from json file-");
//                    int c12=sc.nextInt();
//                    break;
//                case 11:
//                    System.out.println("Enter sort by" +
//                            "1. FirstName" +
//                            "2. City" +
//                            "3. State" +
//                            "4. Zip");
//                    int c13=sc.nextInt();
//                    switch (c13)
//                    {
//                        case 1:
//                            m.SortByName();
//                            break;
//                        case 2:
//                            m.SortByCity();
//                            break;
//                        case 3:
//                            m.SortByState();
//                            break;
//                        case 4:
//                            m.SortByZIP();
//                            break;
//                        default:
//                            System.out.println("invalid choice!!");
//                            break;
//                    }
//                    break;
//                default:
//                    System.exit(0);
//            }
//        }
    }
}
