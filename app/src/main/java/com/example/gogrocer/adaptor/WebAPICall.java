package com.example.gogrocer.adaptor;
import android.app.ProgressDialog;
import android.content.Context;

import com.example.gogrocer.ErrorHandlingUtility;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
public class WebAPICall {
    private static final String TAG = WebAPICall.class.getSimpleName();
    private ProgressDialog progressDialog;
    private Context context;
//    private Controller controller;


    public WebAPICall(Context context) {
        this.context = context;
    }


    public void doGetResponse(String msg, final Call call, boolean isShown, final Response res) {
        if (isShown && (context != null )) {
            progressDialog = new ProgressDialog(context);
            progressDialog.setMessage(msg);
            progressDialog.setCancelable(false);

            try {
                progressDialog.show();
            }catch(Exception e){
                // WindowManager$BadTokenException will be caught
            }

        }else {
//            progressDialog.show();
        }

        callAPI(call, res);

    }


    private void callAPI(Call call, final Response res) {
//        Log.d(TAG, "(++) callAPI");
//        Log.d(TAG, "(++) callAPI"+call.request());
        call.enqueue(new retrofit2.Callback() {

            @Override
            public void onResponse(@NotNull Call call, @NotNull retrofit2.Response response) {
//                Log.i(TAG, "===== request url : " + response.raw().request().url().toString());
                dismissProgress(progressDialog);
                if (response.isSuccessful()) {
                    res.onSuccessResponse(response.body());
                    System.out.println("Response successful Role Name == ");
                    /*try {
                        JSONObject jsonObject = new JSONObject(response.body().toString());
                        JSONObject jsonObject1 = jsonObject.getJSONObject("data");
                        String objectStr = jsonObject1.getString("token");
                        System.out.println("User Token === "+objectStr);
                    }catch (Exception e){
                        e.printStackTrace();
                    }*/


                } else {
                    System.out.println("1=="+response.body());
                    System.out.println(new Gson().toJson( response.message()));
                    System.out.println("3=="+new Gson().toJson(response.errorBody()));
                    System.out.println("4=="+response.toString());
                    System.out.println("Fail Notification == "+response.code());
//                    ErrorHandlingUtility.parseError(response).getMessage();
//                    res.onFailureResponse(""+response.code());
                    try {
                        res.onFailureResponse( "" + ErrorHandlingUtility.parseError( response).getMessage());
                    } catch (Exception e){
                        e.printStackTrace();
                        res.onFailureResponse("Something went wrong");
                    }

                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull Throwable t) {
                dismissProgress(progressDialog);
                System.out.println(call);
                System.out.println("Fail Notification == "+t.getMessage());
                System.out.println("Fail Notification == "+t.getMessage());
                res.onFailureResponse(t.getLocalizedMessage());
            }
        });
    }

    private void dismissProgress(ProgressDialog progressDialog) {
        try {
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public interface Response<T> {
        void onSuccessResponse(T result);

        void onFailureResponse(String message);
    }
}
