import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Netflix {

    public static void main(String[] args) throws Exception {

        List<ShowDetails> showDetailsList = new ArrayList<>();

        String line = "";

        try
        {
            BufferedReader br = new BufferedReader(new FileReader("/Users/tnaidu/Desktop/netflix_titles.csv"));
            line = br.readLine();
            while ((line = br.readLine()) != null)
            {
                String[] record = line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");

                ShowDetails showDetails = new ShowDetails();
                showDetails.setShow_id(record[0]);
                showDetails.setType(record[1]);
                showDetails.setTitle(record[2]);
                showDetails.setDirector(record[3]);
                showDetails.setCast(record[4]);
                showDetails.setCountry(record[5]);
                showDetails.setDate_added(record[6].isEmpty() ? null : new SimpleDateFormat("dd-MMM-yy").parse(record[6]));
                showDetails.setRelease_year(Integer.parseInt(record[7]));
                showDetails.setRating(record[8]);
                showDetails.setDuration(record[9]);
                showDetails.setListed_in(record[10]);
                showDetails.setDescription(record[11]);

                showDetailsList.add(showDetails);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


        int choice,n;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            System.out.println("1. List the first n records where type: XXXXX");
            System.out.println("2. List the first n records where listed_in: XXXXX (may contain other values)");
            System.out.println("3. List the first n records of type: XXXXX where country: XXXXX");
            System.out.println("4. List the top n records where type: XXXXX, start_date: XXXXX and end_date: XXXXX");
            System.out.println("5. List the top n records where listed_in: XXXXX (may contain other values), start_date: XXXXX and end_date: XXXXX");
            System.out.println("6. List the top n records of type: XXXXX where country: XXXXX, start_date: XXXXX and end_date: XXXXX");
            System.out.println("7. Close");
            System.out.println("Select the choice:");

            choice = Integer.parseInt(reader.readLine());

            if(choice==7)
                break;

            switch (choice){
                case 1:
                {
                    System.out.println("Enter the value of type:");
                    String type = reader.readLine();
                    System.out.println("Enter the no. of records:");
                    n = Integer.parseInt(reader.readLine());
                    showDetailsList.stream().filter(showDetails -> showDetails.getType().equals(type)).limit(n).forEach(s -> System.out.println(s));
                    break;
                }
                case 2:
                {
                    System.out.println("Enter the value of listed_in:");
                    String listed_in = reader.readLine();
                    System.out.println("Enter the no. of records:");
                    n = Integer.parseInt(reader.readLine());
                    showDetailsList.stream().filter(showDetails -> showDetails.getListed_in().contains(listed_in)).limit(n).forEach(s -> System.out.println(s));
                    break;
                }
                case 3:
                {
                    System.out.println("Enter the value of type:");
                    String type = reader.readLine();
                    System.out.println("Enter the value of country:");
                    String country = reader.readLine();
                    System.out.println("Enter the no. of records:");
                    n = Integer.parseInt(reader.readLine());
                    showDetailsList.stream()
                            .filter(showDetails -> showDetails.getType().equals(type) && showDetails.getCountry().equals(country)).limit(n).forEach(s -> System.out.println(s));
                    break;
                }
                case 4:
                {
                    System.out.println("Enter the value of type:");
                    String type = reader.readLine();
                    System.out.println("Enter the value of start_date (Eg: 01-Jan-20):");
                    String start_date = reader.readLine();
                    Date sd = new SimpleDateFormat("dd-MMM-yy").parse(start_date);
                    System.out.println("Enter the value of end_date (Eg: 01-Jan-20):");
                    String end_date = reader.readLine();
                    Date ed = new SimpleDateFormat("dd-MMM-yy").parse(end_date);
                    System.out.println("Enter the no. of records:");
                    n = Integer.parseInt(reader.readLine());
                    showDetailsList.stream()
                            .filter(showDetails -> showDetails.getType().equals(type) &&
                                    showDetails.getDate_added().after(sd) &&
                                    showDetails.getDate_added().before(ed)).limit(n).forEach(s -> System.out.println(s));

                    break;
                }
                case 5:
                {
                    System.out.println("Enter the value of listed_in:");
                    String listed_in = reader.readLine();
                    System.out.println("Enter the value of start_date (Eg: 01-Jan-20):");
                    String start_date = reader.readLine();
                    Date sd = new SimpleDateFormat("dd-MMM-yy").parse(start_date);
                    System.out.println("Enter the value of end_date (Eg: 01-Jan-20):");
                    String end_date = reader.readLine();
                    Date ed = new SimpleDateFormat("dd-MMM-yy").parse(end_date);
                    System.out.println("Enter the no. of records:");
                    n = Integer.parseInt(reader.readLine());
                    showDetailsList.stream()
                            .filter(showDetails -> showDetails.getListed_in().contains(listed_in) &&
                                    showDetails.getDate_added().after(sd) &&
                                    showDetails.getDate_added().before(ed)).limit(n).forEach(s -> System.out.println(s));

                    break;
                }
                case 6:
                {
                    System.out.println("Enter the value of type:");
                    String type = reader.readLine();
                    System.out.println("Enter the value of country:");
                    String country = reader.readLine();
                    System.out.println("Enter the value of start_date (Eg: 01-Jan-20):");
                    String start_date = reader.readLine();
                    Date sd = new SimpleDateFormat("dd-MMM-yy").parse(start_date);
                    System.out.println("Enter the value of end_date (Eg: 01-Jan-20):");
                    String end_date = reader.readLine();
                    Date ed = new SimpleDateFormat("dd-MMM-yy").parse(end_date);
                    System.out.println("Enter the no. of records:");
                    n = Integer.parseInt(reader.readLine());
                    showDetailsList.stream()
                            .filter(showDetails -> showDetails.getType().equals(type) && showDetails.getCountry().equals(country) &&
                                    showDetails.getDate_added().after(sd) &&
                                    showDetails.getDate_added().before(ed)).limit(n).forEach(s -> System.out.println(s));

                    break;
                }
                default:
                    break;

            }


        }
    }
}
