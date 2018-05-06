package com.nostratech.mahdi.data.cache

import android.arch.persistence.room.*

@Entity(tableName = "users",
        indices = [(Index(value = ["user"], unique = true))])
data class ContactData(
        @PrimaryKey var id: Long,
        @ColumnInfo(name = "user") var user: String?, // may be non-existent on "traveller" field
        @ColumnInfo(name = "name") var name: String,
        @ColumnInfo(name = "image") var image: String?,
        @ColumnInfo(name = "rating") var rating: String,
        @ColumnInfo(name = "about") var about: String? = null
)

@Entity(tableName = "users_settings")
data class ContactDataSetting(
        @PrimaryKey @ColumnInfo(name = "user_id") val userId: Long,
        @ColumnInfo(name = "new_follower_notification") val newFollowerNotification: Boolean,
        @ColumnInfo(name = "new_comment_notification") val newCommentNotification: Boolean,
        @ColumnInfo(name = "new_request_inspired_notification") val newRequestNotification: Boolean,
        @ColumnInfo(name = "new_post_followed_notification") val newPostFollowedNotification: Boolean,
        @ColumnInfo(name = "withdrawal_related_notifications") val withdrawalNotifications: Boolean,
        @ColumnInfo(name = "request_related_notifications") val requestNotifications: Boolean,
        @ColumnInfo(name = "offer_related_notifications") val offerNotifications: Boolean,
        @ColumnInfo(name = "deal_related_notifications") val dealNotifications: Boolean,
        @ColumnInfo(name = "cancellation_notifications") val cancellationNotifications: Boolean,
        @ColumnInfo(name = "new_message_notification") val newMessageNotification: Boolean
)