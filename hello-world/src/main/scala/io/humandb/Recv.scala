package io.humandb

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;

object Recv {
	val QUEUE_NAME = "hello"

	def main(args: Array[String]): Unit = {
		var factory = new ConnectionFactory
		factory.setHost("localhost")
		
		var connection = factory.newConnection
		var channel = connection.createChannel

		channel.queueDeclare(QUEUE_NAME, false, false, false, null)
		println(" [*] Waiting for messages. To exit press CTRL+C")

		var consumer = new QueueingConsumer(channel)
		channel.basicConsume(QUEUE_NAME, true, consumer)

		while (true) {
			var delivery = consumer.nextDelivery()
			var message: String = new String(delivery.getBody())
			println(" [x] Received '" + message + "'")
		}
	}
}
