package com.addressbook;

import com.google.gson.Gson;

import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public class SortContact {

   static EnumMap<SearchUpdateAndDeleteBy, Comparator<Person>> enumMap
            =new EnumMap(SearchUpdateAndDeleteBy.class);

public static String sortBy(SearchUpdateAndDeleteBy sortingByColumn, List<Person> contactDetails){
    enumMap.put( SearchUpdateAndDeleteBy.SORT_BY_FIRST_NAME,
            Comparator.comparing(sortBy->sortBy.getFirstName()));
    enumMap.put( SearchUpdateAndDeleteBy.SORT_BY_LAST_NAME,
            Comparator.comparing(sortBy->sortBy.getLastName()));
    enumMap.put( SearchUpdateAndDeleteBy.SORT_BY_CITY,
            Comparator.comparing(sortBy->sortBy.getCity()));
    enumMap.put( SearchUpdateAndDeleteBy.SORT_BY_STATE,
            Comparator.comparing(sortBy->sortBy.getState()));
    enumMap.put( SearchUpdateAndDeleteBy.SORT_BY_PHONENUMBER,
            Comparator.comparing(sortBy->sortBy.getPhoneNumber()));
    enumMap.put( SearchUpdateAndDeleteBy.SORT_BY_PINCODE,
            Comparator.comparing(sortBy->sortBy.getPincode()));
    return new Gson().toJson(  contactDetails.stream().sorted(enumMap.get(sortingByColumn)
    ).collect(Collectors.toList()));
}

}
