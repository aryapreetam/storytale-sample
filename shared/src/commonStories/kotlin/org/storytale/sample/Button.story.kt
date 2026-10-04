package org.storytale.sample

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import org.jetbrains.compose.storytale.story

val `Primary Action Button` by story(group = "Buttons") {
  val text by parameter("Click me!")
  val isEnabled by parameter(true)

  Button(
    onClick = {},
    enabled = isEnabled
  ) {
    Text(text)
  }
}