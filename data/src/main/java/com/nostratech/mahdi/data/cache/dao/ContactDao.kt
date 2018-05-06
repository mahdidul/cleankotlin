package com.nostratech.mahdi.data.cache.dao

import android.arch.persistence.room.*
import com.nostratech.mahdi.data.cache.ContactData
import com.nostratech.mahdi.data.cache.ContactDataSetting
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
abstract class ContactDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insertUser(user: ContactData)

    @Update
    abstract fun updateUser(user: ContactData)

    @Transaction
    open fun upsertUser(user: ContactData) {
        insertUser(user)
        updateUser(user)
    }

    @Query("SELECT * FROM users WHERE id = :id")
    abstract fun getUserById(id: Long): Single<ContactData>

    @Query("SELECT * FROM users WHERE id = :id")
    abstract fun getUserByIdFlowable(id: Long): Flowable<ContactData>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insertUserSetting(userSetting: ContactDataSetting)

    @Update
    abstract fun updateUserSetting(userSetting: ContactDataSetting)

    @Transaction
    open fun upsertUserSetting(userSetting: ContactDataSetting) {
        insertUserSetting(userSetting)
        updateUserSetting(userSetting)
    }

    @Query("SELECT * FROM users_settings where user_id = :userId")
    abstract fun getUserSettingByUserId(userId: Long): Flowable<ContactDataSetting>
}
