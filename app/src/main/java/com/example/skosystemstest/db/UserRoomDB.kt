package com.example.skosystemstest.db
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import com.example.skosystemstest.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserRoomDB : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        private var INSTANCE: UserRoomDB? = null

        fun getRoomInstance(context: Context): UserRoomDB {
            if (INSTANCE == null) {
                synchronized(UserRoomDB::class.java) {
                    INSTANCE = Room.databaseBuilder(context,
                        UserRoomDB::class.java,"user_room_db").build()
                }
            }
            return INSTANCE!!
        }

       /* fun getInstance(context: Context): UserRoomDB? {
            if (INSTANCE == null) {
                synchronized(context) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        UserRoomDB::class.java,
                        "user_data"
                    ).build()
                }
            }
            return INSTANCE!!
        }*/

    }
}