package com.avel.data.model

final case class Record(
                   Open_time: String,
                   Open: String,
                   High: String,
                   Low: String,
                   Close: String,
                   Volume: String,
                   Close_time: String,
                   Quote_asset_volume: String,
                   Number_of_trades: String,
                   Taker_buy_base_asset_volume: String,
                   Taker_buy_quote_asset_volume: String
                 )

final case class Record2(
                         Open_time: String,
                         Hour: String,
                         Open: String,
                         High: String,
                         Low: String,
                         Close: String,
                         Volume: String,
                         Close_time: String,
                         Quote_asset_volume: String,
                         Number_of_trades: String,
                         Taker_buy_base_asset_volume: String,
                         Taker_buy_quote_asset_volume: String
                       )
