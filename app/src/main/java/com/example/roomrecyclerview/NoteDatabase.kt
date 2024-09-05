package com.example.roomrecyclerview

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(entities = [Note::class], version = 2)
@TypeConverters(Convertors::class)
/**
 *
 * entities is an array of tables our database would have many tables that's there is array
 * version is for: -  if we make changes in our database in next release then we have to update the version
 *
 *
 */
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {

        /**
         *
         * Volatile means, it will be notified on all threads
         *
         */
        @Volatile
        private var instance: NoteDatabase? = null


        /**
         *
         * if we have changed any thing in our table then we have to migrate the existing user to it, that's why used this.
         * This is the function to migrate the database and make changes and make it to migrate from version 1 to 2.
         *
         */

        var migration_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE note_table ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)")
            }
        }


        fun getInstance(context: Context): NoteDatabase {
            if (instance == null) {
                /**
                 *
                 * Synchronised is used when we have lets say 3-4 threads, all are trying to create instance of db
                 * so synchronised doesn't make it happen, only one instance will be made
                 *
                 */
                synchronized(this) {
                    instance =
                        Room.databaseBuilder(
                            context.applicationContext,
                            klass = NoteDatabase::class.java,
                            name = "note_database"
                        )
                            .addMigrations(migration_1_2)
                            .fallbackTwoDestructiveMigration()
                            .build()
                }
            }
            return instance!!
        }

        private val roomCallback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                populateDatabase(instance!!)
            }
        }

        private fun populateDatabase(instance: NoteDatabase) {

        }


    }


}