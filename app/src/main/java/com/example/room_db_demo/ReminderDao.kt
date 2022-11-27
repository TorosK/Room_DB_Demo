package com.example.room_db_demo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ReminderDao {
    @Query("SELECT * FROM reminder_table")
    fun getAll(): List<Reminder>

    @Query("SELECT * FROM reminder_table WHERE id LIKE :id LIMIT 1")
    suspend fun findByID(id: Int): Reminder

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(reminder: Reminder)

    @Delete
    suspend fun delete(reminder: Reminder)

    @Query("DELETE FROM reminder_table")
    suspend fun deleteAll()

}