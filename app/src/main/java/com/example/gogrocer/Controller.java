package com.example.gogrocer;
import android.content.Context;

import com.example.gogrocer.adaptor.WebAPICall;
import com.example.gogrocer.api.Api;
import com.example.gogrocer.model.Banner_Model;

import retrofit2.Call;
public class Controller {

    public void getAllEntries(Context context, final EntriesDataListener listeners) {
        Api apiInterface = RetrofitClientInstance.getRetrofitInstance().create( Api.class);
        Call callTask = apiInterface.getBanner();
        new WebAPICall( context).doGetResponse( "Fetching Entries...", callTask, true, new WebAPICall.Response() {
            @Override
            public void onSuccessResponse(Object object) {
                try {
                    if (object instanceof Banner_Model) {
                        Banner_Model dto = (Banner_Model) object;
                        listeners.onDetailsFetchedSuccess(dto);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error === " + e.getMessage());
                }
            }

            @Override
            public void onFailureResponse(String message) {
                listeners.onDetailsFetchedFailure(message);
            }
        });
    }

}
