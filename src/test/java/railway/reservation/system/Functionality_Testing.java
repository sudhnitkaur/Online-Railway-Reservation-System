package railway.reservation.system;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.*;
import com.example.demo.model.TrainLocation;
import com.example.demo.model.TimeTable;
import com.example.demo.model.TrainBetweenStation;
import com.example.demo.model.TrainFare;
import com.example.demo.model.ticket.ReserveTicket;
import com.example.demo.model.train.Train;
import com.example.demo.repository.ReservedTicketRepository;
import com.example.demo.service.reservationService.ReservationService;
import com.example.demo.service.trainService.TrainService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
@TestComponent
public class Functionality_Testing {


    // *------------------------------------------ Autowired Services --------------------------------------------*

    @Autowired //eliminates the need for getters and setters.
    private TrainService trainService;
    @Autowired //eliminates the need for getters and setters.
    private ReservationService reservationService;
    @Autowired //eliminates the need for getters and setters.
    private MongoRepository<Train, Long> mongoRepository;
    @Autowired //eliminates the need for getters and setters.
    private ReservedTicketRepository reservedTicketRepository;
    // *----------------------------------------------------------------------------------------------------------*




    // *--------------------------------- TimeTable Functionality Testing ----------------------------------------*

    String timeTableFile;
    List<TimeTable> timeTableList; // to extract the  file from the (source/test/resources)
    JSONArray jsonArray;
    String trainBetweenStationFile;
    List<TrainBetweenStation> trainBetweenStationList; // to extract the  file from the (source/test/resources)
    
    String trainLocationFile;
    List<TrainLocation> trainLocationList; // to extract the time table file from the (source/test/resources)

    String trainFareFile;
    List<TrainFare> trainFareList; // to extract the time table file from the (source/test/resources)
    
    List<TimeTable> getTimeTableList(String timeTableFile) throws JSONException {
        jsonArray = new JSONArray(timeTableFile);
        timeTableList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            timeTableList.add(new TimeTable());
        }
        return timeTableList;
    }

    @Test
    void TimeTable_testcase_1() throws IOException, JSONException {
        timeTableFile = Files.readString(Path.of("src/test/resources/TimeTable-TestCase/TimeTable_TestCase_1.json"));
        timeTableList = getTimeTableList(timeTableFile);
        Assertions.assertEquals(timeTableList.toString(), trainService.displayTimeTable("Karachi City").toString());
		//IOException is usually a case in which the user inputs improper data into the program. 
		// Constructs a new runtime exception with the specified detail message.
        }

    @Test
    void TimeTable_testcase_2() throws IOException, JSONException {
        timeTableFile = Files.readString(Path.of("src/test/resources/TimeTable-TestCase/TimeTable_TestCase_2.json"));
        timeTableList = getTimeTableList(timeTableFile);
	    Assertions.assertEquals(timeTableList.toString(), trainService.displayTimeTable("Lahore Junction").toString());
	 //IOException is usually a case in which the user inputs improper data into the program. 
	 // Constructs a new runtime exception with the specified detail message.
    }

    @Test
    void TimeTable_testcase_3() throws IOException, JSONException {
        timeTableFile = Files.readString(Path.of("src/test/resources/TimeTable-TestCase/TimeTable_TestCase_3.json"));
        timeTableList = getTimeTableList(timeTableFile);
        Assertions.assertEquals(timeTableList.toString(), trainService.displayTimeTable("Multan Cantonment").toString());
        //IOException is usually a case in which the user inputs improper data into the program. 
        // Constructs a new runtime exception with the specified detail message.
    }

    @Test
    void TimeTable_testcase_4() throws IOException, JSONException {
        timeTableFile = Files.readString(Path.of("src/test/resources/TimeTable-TestCase/TimeTable_TestCase_4.json"));
        timeTableList = getTimeTableList(timeTableFile);
        Assertions.assertEquals(timeTableList.toString(), trainService.displayTimeTable("noob city").toString());
      //IOException is usually a case in which the user inputs improper data into the program. 
     // Constructs a new runtime exception with the specified detail message.
    }


    // *-------------------------------------------------------------------------------------------------------------*

    // *-------------------------- TrainsBetweenStation Functionality Testing ---------------------------------------*

    List<TrainBetweenStation> getTrainsBetweenStationList(String TrainsBetweenStationFile) throws JSONException, JsonProcessingException {
                                                                            //Sub-class of IOException;
																			 //IOException is usually a case in which the user inputs improper data into the program. 
																			 // Constructs a new runtime exception with the specified detail message.
        jsonArray = new JSONArray(TrainsBetweenStationFile);
        trainBetweenStationList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);

            ObjectMapper mapper = new ObjectMapper();
            TypeFactory typeFactory = mapper.getTypeFactory();
            MapType mapType = typeFactory.constructMapType(HashMap.class, String.class, Double.class);

            HashMap<String, Double> newmap = mapper.readValue(object.getString("classes"), mapType);
            HashMap<String, Double> map = newmap.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (p, q) -> p, HashMap::new));

            List<String> list = mapper.readValue(object.getString("run_days"), List.class);

            trainBetweenStationList.add(new TrainBetweenStation());
        }
        return trainBetweenStationList;
    }

    @Test
    public void TrainsBetweenStation_testcase_1() throws IOException, JSONException {
        trainBetweenStationFile = Files.readString(Path.of("src/test/resources/TrainsBetweenStation-TestCase/TrainsBetweenStation-TestCase_1.json"));
        trainBetweenStationList = getTrainsBetweenStationList(trainBetweenStationFile);
        Assertions.assertEquals(trainBetweenStationList.toString(), trainService.trainsBetweenStation("Lahore Junction", "Karachi City").toString());
      //IOException is usually a case in which the user inputs improper data into the program. 
        // Constructs a new runtime exception with the specified detail message.
    }

    @Test
    void TrainsBetweenStation_testcase_2() throws IOException, JSONException {
        trainBetweenStationFile = Files.readString(Path.of("src/test/resources/TrainsBetweenStation-TestCase/TrainsBetweenStation-TestCase_2.json"));
        trainBetweenStationList = getTrainsBetweenStationList(trainBetweenStationFile);
        Assertions.assertEquals(trainBetweenStationList.toString(), trainService.trainsBetweenStation("Lahore Junction", "Landhi Junction").toString());
      //IOException is usually a case in which the user inputs improper data into the program. 
        // Constructs a new runtime exception with the specified detail message.
    }

    @Test
    void TrainsBetweenStation_testcase_3() throws IOException, JSONException {
        trainBetweenStationFile = Files.readString(Path.of("src/test/resources/TrainsBetweenStation-TestCase/TrainsBetweenStation-TestCase_3.json"));
        trainBetweenStationList = getTrainsBetweenStationList(trainBetweenStationFile);
        Assertions.assertEquals(trainBetweenStationList.toString(), trainService.trainsBetweenStation("", "").toString());
      //IOException is usually a case in which the user inputs improper data into the program. 
        // Constructs a new runtime exception with the specified detail message.
    }

    @Test
    void TrainsBetweenStation_testcase_4() throws IOException, JSONException {
        trainBetweenStationFile = Files.readString(Path.of("src/test/resources/TrainsBetweenStation-TestCase/TrainsBetweenStation-TestCase_4.json"));
        trainBetweenStationList = getTrainsBetweenStationList(trainBetweenStationFile);
        Assertions.assertEquals(trainBetweenStationList.toString(), trainService.trainsBetweenStation("noob city", "Local City").toString());
      //IOException is usually a case in which the user inputs improper data into the program. 
        // Constructs a new runtime exception with the specified detail message.
    }
    // *------------------------------------------------------------------------------------------------------------------*



    // *---------------------------------------------------------- Train Fare ---------------------------------------------*
    @Test
    public void TrainsFare_testcase_1() throws IOException, JSONException {
        trainBetweenStationFile = Files.readString(Path.of("src/test/resources/TrainFare-TestCase/TrainFare_TestCase_1.json"));
        trainBetweenStationList = getTrainsBetweenStationList(trainBetweenStationFile);
        Assertions.assertEquals(trainBetweenStationList.toString(), trainService.trainFare("Lahore Junction", "Karachi City").toString());
      //IOException is usually a case in which the user inputs improper data into the program. 
        // Constructs a new runtime exception with the specified detail message.
    }

    @Test
    void TrainsFare_testcase_2() throws IOException, JSONException {
        trainBetweenStationFile = Files.readString(Path.of("src/test/resources/TrainFare-TestCase/TrainFare_TestCase_2.json"));
        trainBetweenStationList = getTrainsBetweenStationList(trainBetweenStationFile);
        Assertions.assertEquals(trainBetweenStationList.toString(), trainService.trainFare("Lahore Junction", "Landhi Junction").toString());
      //IOException is usually a case in which the user inputs improper data into the program. 
        // Constructs a new runtime exception with the specified detail message.
    }

    @Test
    void TrainsFare_testcase_3() throws IOException, JSONException {
        trainBetweenStationFile = Files.readString(Path.of("src/test/resources/TrainFare-TestCase/TrainFare_TestCase_3.json"));
        trainBetweenStationList = getTrainsBetweenStationList(trainBetweenStationFile);
        Assertions.assertEquals(trainBetweenStationList.toString(), trainService.trainFare("", "").toString());
      //IOException is usually a case in which the user inputs improper data into the program. 
        // Constructs a new runtime exception with the specified detail message.
    }

    @Test
    void TrainsFare_testcase_4() throws IOException, JSONException {
        trainBetweenStationFile = Files.readString(Path.of("src/test/resources/TrainFare-TestCase/TrainFare_TestCase_4.json"));
        trainBetweenStationList = getTrainsBetweenStationList(trainBetweenStationFile);
        Assertions.assertEquals(trainBetweenStationList.toString(), trainService.trainFare("noob city", "Local City").toString());
      //IOException is usually a case in which the user inputs improper data into the program. 
        // Constructs a new runtime exception with the specified detail message.
        }
    // *-------------------------------------------------------------------------------------------------------------------*




    // *--------------------------------------------------- Display Train ------------------------------------------------*
    @Test
    void train_testcase_1() throws IOException, JSONException {
        String train_no = "410878";
        Train train = mongoRepository.findAll().stream().filter(p->p.getTrain_no().equals(train_no)).collect(Collectors.toList()).get(0);
        Assertions.assertEquals(train.toString(), trainService.displayTrain(train_no).toString());
    // It returns a Stream consisting of the elements of the given stream that match the given predicate. 
        //IOException is usually a case in which the user inputs improper data into the program. 
        // Constructs a new runtime exception with the specified detail message. 
        }
    @Test
    void train_testcase_2() throws IOException, JSONException {
        String train_no = "5555108";
        Train train = new Train(null);
        Assertions.assertEquals(train.toString(), trainService.displayTrain(train_no).toString());
     // It returns a Stream consisting of the elements of the given stream that match the given predicate. 
        //IOException is usually a case in which the user inputs improper data into the program. 
        // Constructs a new runtime exception with the specified detail message. 
        }
    @Test
    void train_testcase_3() throws IOException, JSONException {
        String train_no = "778120";
        Train train = mongoRepository.findAll().stream().filter(p->p.getTrain_no().equals(train_no)).collect(Collectors.toList()).get(0);
        Assertions.assertEquals(train.toString(), trainService.displayTrain(train_no).toString());
     // It returns a Stream consisting of the elements of the given stream that match the given predicate. 
        //IOException is usually a case in which the user inputs improper data into the program. 
        // Constructs a new runtime exception with the specified detail message.
        }
    @Test
    void train_testcase_4() throws IOException, JSONException {
        String train_no = "4108";
        Train train = new Train(null);
        Assertions.assertEquals(train.toString(), trainService.displayTrain(train_no).toString());
    }
 // It returns a Stream consisting of the elements of the given stream that match the given predicate. 
    //IOException is usually a case in which the user inputs improper data into the program. 
    // Constructs a new runtime exception with the specified detail message.
    // *-------------------------------------------------------------------------------------------------------------------*


    // *----------------------------------------------- Get Ticket --------------------------------------------------------*
    @Test
    void pnr_testcase_1() throws IOException, JSONException {
        String train_no = "410878";
        Train train = mongoRepository.findAll().stream().filter(p->p.getTrain_no().equals(train_no)).collect(Collectors.toList()).get(0);
        Assertions.assertEquals(train.toString(), trainService.displayTrain(train_no).toString());
    }
 // It returns a Stream consisting of the elements of the given stream that match the given predicate. 
    //IOException is usually a case in which the user inputs improper data into the program. 
    // Constructs a new runtime exception with the specified detail message.
    @Test
    void pnr_testcase_2() throws IOException, JSONException {
        String train_no = "5555108";
        Train train = new Train(null);
        Assertions.assertEquals(train.toString(), trainService.displayTrain(train_no).toString());
    }
    // It returns a Stream consisting of the elements of the given stream that match the given predicate. 
    //IOException is usually a case in which the user inputs improper data into the program. 
    // Constructs a new runtime exception with the specified detail message.
    @Test
    void pnr_testcase_3() throws IOException, JSONException {
        String train_no = "778120";
        Train train = mongoRepository.findAll().stream().filter(p->p.getTrain_no().equals(train_no)).collect(Collectors.toList()).get(0);
        Assertions.assertEquals(train.toString(), trainService.displayTrain(train_no).toString());
    }
    // It returns a Stream consisting of the elements of the given stream that match the given predicate. 
    //IOException is usually a case in which the user inputs improper data into the program. 
    // Constructs a new runtime exception with the specified detail message.
    @Test
    void pnr_testcase_4() throws IOException, JSONException {
        String train_no = "4108";
        Train train = new Train(null);
        Assertions.assertEquals(train.toString(), trainService.displayTrain(train_no).toString());
    }
    // It returns a Stream consisting of the elements of the given stream that match the given predicate. 
    //IOException is usually a case in which the user inputs improper data into the program. 
    // Constructs a new runtime exception with the specified detail message.
    // *-------------------------------------------------------------------------------------------------------------------*



    // *----------------------------------------------- Ticket cancellation -----------------------------------------------*
    @Test
    public void ticketCancellation_TestCase_1()
    {
        long pnr = 1231112L;
        ReserveTicket reservedTicket = new ReserveTicket();
        reservedTicket.setPnr(pnr);
        reservedTicketRepository.save(reservedTicket);
        Assertions.assertEquals("success",reservationService.ticketCancellation(pnr));
    }//IOException is usually a case in which the user inputs improper data into the program. 
    // Constructs a new runtime exception with the specified detail message.
    @Test
    public void ticketCancellation_TestCase_2()
    {
        long pnr = 12312312L;
        ReserveTicket reservedTicket = new ReserveTicket();
        reservedTicket.setPnr(pnr);
        reservedTicketRepository.save(reservedTicket);
        Assertions.assertEquals("success",reservationService.ticketCancellation(pnr));
    }//IOException is usually a case in which the user inputs improper data into the program. 
    // Constructs a new runtime exception with the specified detail message.
    @Test
    public void ticketCancellation_TestCase_3()
    {
        long pnr = 12312312L;
        Assertions.assertEquals("!!! Invalid PNR !!! , Please write Information correctly.",reservationService.ticketCancellation(pnr));
    }//IOException is usually a case in which the user inputs improper data into the program. 
    // Constructs a new runtime exception with the specified detail message.
    @Test
    public void ticketCancellation_TestCase_4()
    {
        long pnr = 12312312L;
        Assertions.assertEquals("!!! Invalid PNR !!! , Please write Information correctly.",reservationService.ticketCancellation(pnr));
    }//IOException is usually a case in which the user inputs improper data into the program. 
    // Constructs a new runtime exception with the specified detail message.
    // *--------------------------------------------------------------------------------------------------------------------*

}
//Asserts that two objects are equal. If they are not, an AssertionError without a message is thrown
