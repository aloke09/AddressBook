package AddressBook;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opencsv.CSVWriter;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

public class methods
{
    Scanner sc=new Scanner(System.in);
    HashMap<String,Contact>map=new LinkedHashMap<>();
//    public void addContact(String code,Contact contact)
//    {
//        map.put(code,contact);
//    }
    public void addContact()
    {
        System.out.println("Enter first name");
        String fName=sc.next();
        System.out.println("Enter last name");
        String lName=sc.next();
        System.out.println("Enter address");
        String address=sc.next();
        System.out.println("Enter city");
        String city=sc.next();
        System.out.println("Enter state");
        String state=sc.next();
        System.out.println("Enter email");
        String mail=sc.next();
        System.out.println("Enter zip");
        int zip=sc.nextInt();
        System.out.println("Enter phno");
        long phno=sc.nextLong();
        Contact c1=new Contact(fName,lName,address,city,state,mail,zip,phno);
        if(map.containsKey(fName))
        {
            System.out.println("cant add duplicate ie contact overriden");
            map.put(fName,c1);
        }
        else {
            map.put(fName,c1);
            System.out.println("contact added successfully");
        }
    }
    public void displayAll()
    {
        map.entrySet().forEach(System.out::println);
    }
    public void editContact(String fname)
    {
        if(!map.containsKey(fname))
        {
            System.out.println("contact does not exists");
        }
        else {
            System.out.println("Enter first name");
            String fName2=sc.next();
            System.out.println("Enter last name");
            String lName2=sc.next();
            System.out.println("Enter address");
            String address2=sc.next();
            System.out.println("Enter city");
            String city2=sc.next();
            System.out.println("Enter state");
            String state2=sc.next();
            System.out.println("Enter email");
            String mail2=sc.next();
            System.out.println("Enter zip");
            int zip2=sc.nextInt();
            System.out.println("Enter phno");
            long phno2=sc.nextLong();
            Contact c2=new Contact(fName2,lName2,address2,city2,state2,mail2,zip2,phno2);
            map.put(fname,c2);
            System.out.println("data updated successfully");
        }
    }
    public void delContact(String fname)
    {
        if(!map.containsKey(fname))
        {
            System.out.println("contact does not exists");
        }
        else {
            map.remove(fname);
            System.out.println("Contact deleted successfully");
        }
    }
    public void addMultiple(int n)
    {
        for(int i=0;i<n;i++)
        {
            System.out.println(i);
            new methods().addContact();
        }
    }
//    public void refactor()
//    {
//
//    }
    public void SortByName()
    {
        Map<String, Contact> sortedMapByName = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Contact::getFirstName)))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
        map.clear();
        map.putAll(sortedMapByName);
    }
    public void SortByCity()
    {
        Map<String, Contact> sortedMapByCity = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Contact::getCity)))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
        map.clear();
        map.putAll(sortedMapByCity);
    }
    public void SortByState()
    {
        Map<String, Contact> sortedMapByState = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Contact::getState)))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
        map.clear();
        map.putAll(sortedMapByState);
    }
    public void SortByZIP()
    {
        Map<String, Contact> sortedMapByZip = map.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.comparing(Contact::getZip)))
            .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (oldValue, newValue) -> oldValue,
                    LinkedHashMap::new
            ));
        map.clear();
        map.putAll(sortedMapByZip);

    }
    public void AllContactInACity(String city)
    {
        map.entrySet().stream()
                .filter(f->f.getValue().getCity().equals(city))
                .forEach(System.out::println);
    }
    public void AllContactInAState(String state)
    {
        map.entrySet().stream()
                .filter(f->f.getValue().getState().equals(state))
                .forEach(System.out::println);
    }
    //Get Count of Contact by city/state
    public void ContactCountByCity(String city)
    {
        long count = map.entrySet().stream()
                .filter(f -> f.getValue().getCity().equalsIgnoreCase(city)).count();
        System.out.println("Total number of contact in city "+city+" is "+count);
    }
    public void ContactCountByState(String state)
    {
        long count = map.entrySet().stream()
                .filter(f -> f.getValue().getCity().equalsIgnoreCase(state)).count();
        System.out.println("Total number of contact in state "+state+" is "+count);
    }
    //Search person in city/state
    public void PersonInCity(String name,String city)
    {
        map.entrySet().stream()
                .filter(f->f.getValue().getCity().equalsIgnoreCase(city))
                .filter(f->f.getValue().getFirstName().equalsIgnoreCase(name))
                .forEach(System.out::println);
    }
    public void PersonInstate(String name,String state)
    {
        map.entrySet().stream()
                .filter(f->f.getValue().getCity().equalsIgnoreCase(state))
                .filter(f->f.getValue().getFirstName().equalsIgnoreCase(name))
                .forEach(System.out::println);
    }
    public boolean choiceCityState()
    {
        System.out.println("Press 1 for CITY\nPress 2 for State");
        int c=sc.nextInt();
        if (c==1)
        {
            return true;
        }
        return false;
    }
//    public void WriteInSimpleTXTFile() throws IOException {
//        String filePath="C:\\Users\\Aloke\\IdeaProjects\\AddressBook\\src\\main\\java\\AddressBook\\simple.txt";
//        File f=new File(filePath);
//        BufferedWriter br = new BufferedWriter(new FileWriter(f));
//        for (Map.Entry<String, Contact> entry : map.entrySet())
//        {
//            // put key and value separated by a colon
//            br.write(entry.getKey() + ":" + entry.getValue());
//            // new line
//            br.newLine();
//        }
//    }
//    public void readFromSimpleTXTFile() throws IOException {
//        String filePath="C:\\Users\\Aloke\\IdeaProjects\\AddressBook\\src\\main\\java\\AddressBook\\simple.txt";
//        File f=new File(filePath);
//        BufferedReader br=new BufferedReader(new FileReader(f));
//        for (Map.Entry<String, Contact> entry : map.entrySet())
//        {
//            br.read((entry.getKey() + ":" + entry.getValue()).toCharArray());
//        }
//    }
    public void writeToFile() throws IOException {
        String filePath="C:\\Users\\Aloke\\IdeaProjects\\AddressBook\\src\\main\\java\\AddressBook\\simple1.txt";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(map);
        }
    }

    public HashMap readFromFile() throws IOException, ClassNotFoundException {
        String filePath="C:\\Users\\Aloke\\IdeaProjects\\AddressBook\\src\\main\\java\\AddressBook\\simple1.txt";

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (HashMap) ois.readObject();
        }
    }
    public void WriteToCSV()
    {
        String filePath="C:\\Users\\Aloke\\IdeaProjects\\AddressBook\\src\\main\\java\\AddressBook\\simple2.csv";
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            //heading
            writer.writeNext(new String[]{"Key", "FirstName", "LastName", "Address", "City", "State", "Zip", "PhoneNumber", "Email"});

            // Writing data into csv file
            for (Map.Entry<String, Contact> entry : map.entrySet()) {
                Contact contact = entry.getValue();
                writer.writeNext(new String[]{
                        entry.getKey(),
                        contact.getFirstName(),
                        contact.getLastNames(),
                        contact.getAddress(),
                        contact.getCity(),
                        contact.getState(),
                        String.valueOf(contact.getZip()),
                        String.valueOf(contact.getPhoneNumber()),
                        contact.getEmail()
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readFromCSVFile()
    {
        String filePath="C:\\Users\\Aloke\\IdeaProjects\\AddressBook\\src\\main\\java\\AddressBook\\simple2.csv";

        Map<String, Contact> mapForDisplay = new LinkedHashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String key = values[0];
                Contact contact = getContact(values);
                mapForDisplay.put(key, contact);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Contact getContact(String[] values) {
        String firstName = values[1];
        String lastName = values[2];
        String address = values[3];
        String city = values[4];
        String state = values[5];
        String zip = values[6];
        String phoneNumber = values[7];
        String email = values[8];
        return new Contact(firstName, lastName, address, city, state,
                email,Integer.parseInt(zip), Long.parseLong(phoneNumber));
    }
    public void WriteToJSON()
    {
        String filePath="C:\\Users\\Aloke\\IdeaProjects\\AddressBook\\src\\main\\java\\AddressBook\\simple3.json";

        // Convert the LinkedHashMap to JSON and write it to a file
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            mapper.writeValue(new File(filePath), map);
            System.out.println("address book data inserted to json successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readFromJSON()
    {
        String filePath="C:\\Users\\Aloke\\IdeaProjects\\AddressBook\\src\\main\\java\\AddressBook\\simple3.json";
        Gson gson = new Gson();
        // Define the type of the Map
        Type mapType = new TypeToken<LinkedHashMap<String, Contact>>() {}.getType();

        // Read the JSON file into a LinkedHashMap
        try (FileReader reader = new FileReader(filePath)) {
            Map<String, Contact> map = gson.fromJson(reader, mapType);
            map.forEach((key, contact) -> System.out.println("Key: " + key + ", " + contact));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
