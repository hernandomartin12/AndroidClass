package id.ac.umn.week09_36671;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MahasiswaRepository {
    private id.ac.umn.week09_36671.MahasiswaDAO daoMahasiswa;
    private LiveData<List<id.ac.umn.week09_36671.Mahasiswa>> daftarMahasiswa;

    MahasiswaRepository(Application app){
        id.ac.umn.week09_36671.MahasiswaRoomDatabase db =
                id.ac.umn.week09_36671.MahasiswaRoomDatabase.getDatabase(app);
        daoMahasiswa = db.daoMahasiswa();
        daftarMahasiswa = daoMahasiswa.getAllMahasiswa();
    }
    LiveData<List<id.ac.umn.week09_36671.Mahasiswa>> getDaftarMahasiswa(){
        return this.daftarMahasiswa;
    }
    public void insert(id.ac.umn.week09_36671.Mahasiswa mhs){
        new insertAsyncTask(daoMahasiswa).execute(mhs);
    }

    public void deleteAll(){
        new deleteAllAsyncTask(daoMahasiswa).execute();
    }
    public void delete(id.ac.umn.week09_36671.Mahasiswa mhs) {
        new deleteAsyncTask(daoMahasiswa).execute(mhs);
    }
    public void update(id.ac.umn.week09_36671.Mahasiswa mhs) {
        new updateAsyncTask(daoMahasiswa).execute(mhs);
    }
    private static class insertAsyncTask extends
            AsyncTask<id.ac.umn.week09_36671.Mahasiswa, Void, Void> {
        private id.ac.umn.week09_36671.MahasiswaDAO asyncDaoMahasiswa;
        insertAsyncTask(id.ac.umn.week09_36671.MahasiswaDAO dao){
            this.asyncDaoMahasiswa = dao;
        }
        @Override
        protected Void doInBackground(final id.ac.umn.week09_36671.Mahasiswa... mahasiswa){
            asyncDaoMahasiswa.insert(mahasiswa[0]);
            return null;
        }
    }
    private static class deleteAllAsyncTask extends
            AsyncTask<Void, Void, Void> {
        private id.ac.umn.week09_36671.MahasiswaDAO asyncDaoMahasiswa;
        deleteAllAsyncTask(id.ac.umn.week09_36671.MahasiswaDAO dao){
            this.asyncDaoMahasiswa = dao;
        }
        @Override
        protected Void doInBackground(final Void... voids) {
            asyncDaoMahasiswa.deleteAll();
            return null;
        }
    }
    private static class deleteAsyncTask extends
            AsyncTask<id.ac.umn.week09_36671.Mahasiswa, Void, Void>{
        private id.ac.umn.week09_36671.MahasiswaDAO asyncDaoMahasiswa;
        deleteAsyncTask(id.ac.umn.week09_36671.MahasiswaDAO dao){
            this.asyncDaoMahasiswa = dao;
        }
        @Override
        protected Void doInBackground(final id.ac.umn.week09_36671.Mahasiswa... mahasiswas){
            asyncDaoMahasiswa.delete(mahasiswas[0]);
            return null;
        }
    }
    private static class updateAsyncTask extends
            AsyncTask<id.ac.umn.week09_36671.Mahasiswa, Void, Void>{
        private id.ac.umn.week09_36671.MahasiswaDAO asyncDaoMahasiswa;
        updateAsyncTask(id.ac.umn.week09_36671.MahasiswaDAO dao){
            this.asyncDaoMahasiswa = dao;
        }
        @Override
        protected Void doInBackground(final id.ac.umn.week09_36671.Mahasiswa... mahasiswas){
            asyncDaoMahasiswa.update(mahasiswas[0]);
            return null;
        }
    }
}