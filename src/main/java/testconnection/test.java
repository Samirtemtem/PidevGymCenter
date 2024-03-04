package testconnection;

import Controllers.SMSController;
import Entities.Client;
import Entities.User;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;


public class test {


    public static void main(String[] args) {
        SMSController.Sms(new Client());
        }
    }