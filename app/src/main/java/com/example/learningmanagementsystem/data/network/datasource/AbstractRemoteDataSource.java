package com.example.learningmanagementsystem.data.network.datasource;


import com.example.learningmanagementsystem.data.network.ApiInterface;
import com.example.learningmanagementsystem.data.network.NetTool;

public abstract class AbstractRemoteDataSource {
    protected final String TAG = getClass().getSimpleName();
    protected final ApiInterface mApiInterface = NetTool.getNetTool().create(ApiInterface.class);

}
