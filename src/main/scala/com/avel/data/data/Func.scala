package com.avel.data.data

import com.avel.data.model.{Record, Record2}

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Date
import scala.util.Try

object Func {
  private val asHourFormatting = new SimpleDateFormat("hh")

  private def getHour(openTime: String) : Option[String] = {
    Try {
      val openTimeLong = openTime.toLong
      val stamp = new Timestamp(openTimeLong)
      val date = new Date(stamp.getTime())
      asHourFormatting.format(date)
    }.toOption
  }

  def add_hour(input: Record) : Record2 = {
    Record2(
      Open_time = input.Open_time,
      Hour = getHour(input.Open_time).getOrElse(""),
      Open = input.Open,
      High = input.High,
      Low = input.Low,
      Close = input.Close,
      Volume = input.Volume,
      Close_time = input.Close_time,
      Quote_asset_volume = input.Quote_asset_volume,
      Number_of_trades = input.Number_of_trades,
      Taker_buy_base_asset_volume = input.Taker_buy_base_asset_volume,
      Taker_buy_quote_asset_volume = input.Taker_buy_quote_asset_volume
    )
  }
}
