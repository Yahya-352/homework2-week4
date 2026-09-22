package com.ga.homework;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/cities")
public class CityController {

    HashMap<Integer , String> hm = new HashMap<>();

    public CityController(){
        hm.put(1, "London");
        hm.put(2, "Dubai");
        hm.put(3, "Manama");
        hm.put(4, "Doha");
        hm.put(5, "Frankfurt");
        hm.put(6, "Moscow");
        hm.put(7, "California");
    }

    @GetMapping("/")
    public String root(){
        return "Welcome to City Explorer Home Page";
    }

    @GetMapping("/getcities")
    public HashMap<Integer,String> getAllCities(){
        return hm;
    }

    @GetMapping("/getcities/{id}")
    public Map<String, String> getCity(@PathVariable int id){
        Map<String, String> response = new HashMap<>();
        if(!hm.containsKey(id)){
            response.put("message" , "city not found");
        }else{
            response.put("CITY" , hm.get(id));
        }
        return response;
    }

    @GetMapping("/search")
    public Map<String , Object> searchCities(@RequestParam String name){
        List<String> matches = new ArrayList<>();
        for(String city : hm.values()){
            if(city.toLowerCase().contains(name.toLowerCase())){
                matches.add(city);
            }
        }
        Map<String, Object> response = new HashMap<>();
        if (matches.isEmpty()) {
            response.put("message", "No cities matched your search");
        } else {
            response.put("results", matches);
        }
        return response;
    }

    @GetMapping("/addcity")
    public Map<String, String> addCity(@RequestParam String name){
        Map<String, String> response = new HashMap<>();

        if (name == null) {
            response.put("message", "City name is required");
            return response;
        }

        int newId = Collections.max(hm.keySet()) + 1;
        hm.put(newId, name);

        response.put("message", "City added successfully");
        response.put("name", name);
        return response;
    }

    @GetMapping("/deletecity/{id}")
    public Map<String, String> deleteCity(@PathVariable int id){
        Map<String, String> response = new HashMap<>();

        if (!hm.containsKey(id)) {
            response.put("message", "City not found");
            return response;
        }

        String removed = hm.remove(id);
        response.put("message", "City deleted successfully");
        response.put("deletedCity", removed);
        return response;
    }

    @GetMapping("/updatecity/{id}")
    public Map<String, String> updateCity(@PathVariable int id, @RequestParam String name){
        Map<String, String> response = new HashMap<>();

        if (!hm.containsKey(id)) {
            response.put("message", "City not found");
            return response;
        }

        String oldName = hm.get(id);
        hm.put(id, name);

        response.put("message", "City updated successfully");
        return response;
    }

    @GetMapping("/stats")
    public Map<String, Integer> getStats(){
        Map<String, Integer> response = new HashMap<>();
        response.put("totalCities", hm.size());
        return response;
    }



}
