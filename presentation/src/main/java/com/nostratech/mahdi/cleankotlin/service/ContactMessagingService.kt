package com.nostratech.mahdi.cleankotlin.service

import android.accounts.AccountManager
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.RingtoneManager
import android.support.v4.app.NotificationCompat
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.nostratech.mahdi.cleankotlin.R
import com.nostratech.mahdi.cleankotlin.view.ContactPreference
import dagger.android.AndroidInjection
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

/**
 * Created by Mahdi on 06/05/18.
 * Part of clean_kotlin
 */
class ContactMessagingService: FirebaseMessagingService() {

    @Inject
    lateinit var gibbyPreference: ContactPreference

    @Inject
    lateinit var eventBus: EventBus

    override fun onCreate() {
        super.onCreate()
        AndroidInjection.inject(this)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {

        Log.d(TAG, "fcm message from :$remoteMessage")

        val notificationData = remoteMessage?.notification?.body ?: return
        Log.d(TAG, "notification message from :${remoteMessage.notification?.body ?: "" }")
        val messageData = remoteMessage.data ?: return
        Log.d(TAG, "receiving message from :${remoteMessage.data}")

//        if (accountManager.accounts == null) return

        var intent: Intent? = null
        /*when(messageData[PushConstants.TYPE]){
            PushType.REQUEST_OFFER -> {
                intent = Intent(this, MainActivity::class.java)
            }
            PushType.OFFER_ACCEPTED -> {
                intent = Intent(this, OfferStatusActivity::class.java)
                        .putExtra(OfferStatusActivity.REQUEST_ID, messageData[PushConstants.REQUEST_ID]?.toInt())
            }
            PushType.OFFER_REJECTED -> {
                intent = Intent(this, OfferStatusActivity::class.java)
                        .putExtra(OfferStatusActivity.REQUEST_ID, messageData[PushConstants.REQUEST_ID]?.toInt())
            }
            PushType.TRAVELLER_CANCEL -> {
                intent = Intent(this, MainActivity::class.java)
            }
            PushType.REQUESTER_CANCEL -> {
                intent = Intent(this, OfferStatusActivity::class.java)
                        .putExtra(OfferStatusActivity.REQUEST_ID, messageData[PushConstants.REQUEST_ID]?.toInt())
            }
            PushType.REQUEST_PURCHASED -> {
                intent = Intent(this, MainActivity::class.java)
            }
            PushType.REQUEST_DELIVERED -> {
                intent = Intent(this, MainActivity::class.java)
            }
            PushType.REQUEST_RECEIVED_CONFIRM -> {
                intent = Intent(this, OfferStatusActivity::class.java)
                        .putExtra(OfferStatusActivity.REQUEST_ID, messageData[PushConstants.REQUEST_ID]?.toInt())
            }

            PushType.CHAT_INBOX -> {
                Log.d(TAG, "getting message CHAT_INBOX")
                intent = if (gibbyPreference.getUserMode() == UserMode.TRAVELLER)
                    Intent(this, TravellerMainActivity::class.java)
                            .putExtra(TravellerMainActivity.CONTENT_MODE, TravellerMainActivity.INBOX_MODE)
                else Intent(this, MainActivity::class.java)
                        .putExtra(MainActivity.CONTENT_MODE, MainActivity.INBOX_MODE)
            }
            else -> Unit
        }*/

        /*if(intent != null) {
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            val pendingIntent = PendingIntent.
                    getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT)
            if (messageData[PushConstants.TYPE] == PushType.CHAT_INBOX) {
                showNotification(remoteMessage.notification?.body,
                        messageData[PushConstants.ROOM_ID]?.toInt(),
                        pendingIntent, remoteMessage.notification?.title)
            } else {
                showNotification(remoteMessage.notification?.body,
                        messageData[PushConstants.ROOM_ID]?.toInt(), pendingIntent)
            }

            val roomId = messageData[PushConstants.ROOM_ID] ?: "0"
            val roomName = messageData[PushConstants.ROOM_NAME] ?: ""

            eventBus.post(ChatInboxEvent(roomId.toInt(), roomName))

        } else {
            intent = (gibbyPreference.getUserMode() == UserMode.TRAVELLER).let {
                Intent(this, if (it) TravellerMainActivity::class.java else MainActivity::class.java)
            }
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            val pendingIntent = PendingIntent.
                    getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT)
            showNotification(notificationData,
                    messageData[PushConstants.REQUEST_ID]?.toInt(), pendingIntent)
        }*/
    }

    private fun showNotification(message: String?, identifier: Int?, intent: PendingIntent, title: String? = "Gibby") {
        val builder = NotificationCompat.Builder(this, PUSH_CHANNEL_ID)
        val style = NotificationCompat.InboxStyle()
        style.setBigContentTitle(message)

        builder.apply {
            setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
            setContentTitle(title)
            setContentText(message)
            setStyle(NotificationCompat.BigTextStyle().bigText(message))
            setContentIntent(intent)
            setGroupSummary(true)
            setGroup("Gibby")
            setSmallIcon(R.mipmap.ic_launcher)
            setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher_round))
            setAutoCancel(true)
        }
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//        notificationManager.notify(identifier ?: PushConstants.ORDER_PUSH_NOTIFICATION_ID, builder.build())
    }

    companion object {
        const val TAG = "GibbyMessagingService"
        const val PUSH_CHANNEL_ID = "request_offer_notification"
    }
}