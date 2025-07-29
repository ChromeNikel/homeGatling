package otus202505

import io.gatling.core.Predef._
import io.gatling.core.structure.{ChainBuilder, ScenarioBuilder}

object OtusScenario {
  def apply(): ScenarioBuilder = new OtusScenario().scn
}


class OtusScenario {

  val loginGroup: ChainBuilder = group("login") {
    exec(ActionOtus.getMainPage)
      .exec(ActionOtus.getUserSession)
      .exec(ActionOtus.postLogin)
  }

  val byingTicketsGroup: ChainBuilder = group("byingTickets") {
    exec(ActionOtus.getMainPage)
      .exec(ActionOtus.getFlights)
      .exec(ActionOtus.postGoToFindFlights)
      .exec(ActionOtus.postToPaymentDetails)
      .exec(ActionOtus.postMakePayment)
      .exec(ActionOtus.getMainPage)
  }
  val scn = scenario("Scenario finding max")
    .feed(Feeders.users)
    .exec(loginGroup)
    .exec(byingTicketsGroup)
}
