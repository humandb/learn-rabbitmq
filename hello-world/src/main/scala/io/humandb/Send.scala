package io.humandb

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

object Send {
	val QUEUE_NAME = "hello"
	
	def main(args: Array[String]): Unit = {
		var factory = new ConnectionFactory()
		factory.setHost("localhost")
		
		var connection = factory.newConnection()
		var channel    = connection.createChannel()
		channel.queueDeclare(QUEUE_NAME, false, false, false, null)

		val message = "Hello World!"
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes())
		println(" [x] Sent '" + message + "'")

		channel.close
		connection.close
	}
}
