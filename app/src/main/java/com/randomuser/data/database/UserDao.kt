package com.randomuser.data.database


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun getUsersList(): LiveData<List<UserDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(userDbModel: UserDbModel)

    @Query("DELETE FROM users WHERE id=:userId")
    suspend fun deleteUser(userId: Int)

    @Query("SELECT * FROM users WHERE id=:userId LIMIT 1")
    suspend fun getUser(userId: Int): UserDbModel

}