package com.example.gogrocer;
import com.example.gogrocer.model.Banner_Model;
/**********************************
 * Created by Manish on 07-Apr-20
 ***********************************/
public interface EntriesDataListener {
    void onDetailsFetchedSuccess(Banner_Model dto);
    void onDetailsFetchedFailure(String msg);
}
