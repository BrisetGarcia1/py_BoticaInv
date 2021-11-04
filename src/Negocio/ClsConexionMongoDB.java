/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author USUARIO
 */
public class ClsConexionMongoDB {

    public ClsConexionMongoDB(){                    
    }    
    public MongoDatabase conexion(){
        MongoDatabase conexion = new MongoClient().getDatabase("bdboticainv");
        return conexion;
    }
    
//    public MongoDatabase conexion2(){
//        ConnectionString connectionString = new ConnectionString("mongodb://admin12:2000celia08123@cluster0-shard-00-00.1l7e7.mongodb.net:27017,cluster0-shard-00-01.1l7e7.mongodb.net:27017,cluster0-shard-00-02.1l7e7.mongodb.net:27017/BoticaInv?ssl=true&replicaSet=atlas-sg6hid-shard-0&authSource=admin&retryWrites=true&w=majority");
//        MongoClientSettings settings = MongoClientSettings.builder()
//                .applyConnectionString(connectionString)
//                .build();
//        MongoClient mongoClient = (MongoClient) MongoClients.create(settings);
//        MongoDatabase database = mongoClient.getDatabase("BoticaInv");
//        
//        return database;
//    }
    

    
    

}
