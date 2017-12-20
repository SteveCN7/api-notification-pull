/*
 * Copyright 2017 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.apinotificationpull.controllers

import java.util.UUID

import play.api.test.FakeRequest
import play.api.http.Status._
import uk.gov.hmrc.play.test.{UnitSpec, WithFakeApplication}

class NotificationsControllerSpec extends UnitSpec with WithFakeApplication {
  "delete notification by id" when {
    "notification does not exist" should {
      "return 404 NOT_FOUND response" in {
        val notificationId = UUID.randomUUID()
        val controller = new NotificationsController

        val result = controller.delete(notificationId.toString).apply(FakeRequest("DELETE", s"/$notificationId"))

        status(result) shouldBe NOT_FOUND
      }
    }
  }
}
