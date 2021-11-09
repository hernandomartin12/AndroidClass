package id.ac.umn.week09_36671;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MahasiswaViewModel extends AndroidViewModel {

    private MahasiswaRepository mhsRepository;

    private LiveData<List<id.ac.umn.week09_36671.Mahasiswa>> daftarMahasiswa;
    public MahasiswaViewModel(@NonNull Application application) {
        super(application);
        mhsRepository = new MahasiswaRepository(application);
        daftarMahasiswa = mhsRepository.getDaftarMahasiswa();
    }
    LiveData<List<id.ac.umn.week09_36671.Mahasiswa>> getDaftarMahasiswa(){
        return this.daftarMahasiswa;
    }
    public void insert(id.ac.umn.week09_36671.Mahasiswa mhs) {
        mhsRepository.insert(mhs);
    }

    public void deleteAll() {
        mhsRepository.deleteAll();
    }
    public void delete(id.ac.umn.week09_36671.Mahasiswa mhs) {
        mhsRepository.delete(mhs);
    }
    public void update(id.ac.umn.week09_36671.Mahasiswa mhs) {
        mhsRepository.update(mhs);
    }
}

