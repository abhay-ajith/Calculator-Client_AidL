package com.elektrobit.service.arithmeticservice;

import android.content.Intent;

public class ServiceIntentBuilder {
    public static Intent buildArithmeticServiceBindIntent() {
//        Intent intent = new Intent();
//        intent.setClassName("com.elektrobit.service.arithmeticservice","com.elektrobit.service.arithmeticservice.ArithmeticService");
        // The acton is from the Service's intent-filter declaration in the manifest
        return new Intent("com.elektrobit.service.arithmeticservice.ArithmeticService.BIND")
                .setPackage("com.elektrobit.service.arithmeticservice");




    }

}
