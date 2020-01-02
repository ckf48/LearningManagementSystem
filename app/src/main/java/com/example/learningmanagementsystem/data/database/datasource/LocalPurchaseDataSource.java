package com.example.learningmanagementsystem.data.database.datasource;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.learningmanagementsystem.data.database.AppDatabase;
import com.example.learningmanagementsystem.data.database.dao.PurchaseDao;
import com.example.learningmanagementsystem.data.datasource.PurchaseDataSource;
import com.example.learningmanagementsystem.model.Purchase;

import java.util.List;

public class LocalPurchaseDataSource extends AbstractLocalDataSource implements PurchaseDataSource {
    private final PurchaseDao mPurchaseDao;

    public LocalPurchaseDataSource(AppDatabase appDatabase) {
        super(appDatabase);
        mPurchaseDao = appDatabase.purchaseDao();
    }

    private static class deleteAllTask extends AsyncTask<Void, Void, Void> {
        private final PurchaseDao mPurchaseDao;

        public deleteAllTask(PurchaseDao purchaseDao) {
            mPurchaseDao = purchaseDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mPurchaseDao.deleteAll();
            return null;
        }
    }

    public void deleteAll() {
        new deleteAllTask(mPurchaseDao).execute();
    }

    private static class insertTask extends AsyncTask<Purchase, Void, Void> {
        private final PurchaseDao mPurchaseDao;

        public insertTask(PurchaseDao purchaseDao) {
            mPurchaseDao = purchaseDao;
        }

        @Override
        protected Void doInBackground(Purchase... purchases) {
            mPurchaseDao.insert(purchases);
            return null;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void insert(List<Integer> list, int id) {
        list.forEach(integer -> new insertTask(mPurchaseDao).execute(new Purchase(id, integer)));
    }

    @Override
    public void purchase(Context context, PurchaseCallback callback, int cid, int uid) {
        //ignore
    }
}
