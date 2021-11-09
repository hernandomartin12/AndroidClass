package id.ac.umn.week09_36671;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MahasiswaDAO {
    @Query("SELECT * FROM tblMahasiswa")
    LiveData<List<id.ac.umn.week09_37352.Mahasiswa>> getAllMahasiswa();
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(id.ac.umn.week09_37352.Mahasiswa mhs);
    @Delete
    void delete(id.ac.umn.week09_37352.Mahasiswa mhs);
    @Update
    void update(id.ac.umn.week09_37352.Mahasiswa mhs);
    @Query("DELETE FROM tblMahasiswa")
    void deleteAll();
}