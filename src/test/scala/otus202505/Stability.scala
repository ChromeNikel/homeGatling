package otus202505

import io.gatling.core.Predef.{Simulation, _}


class Stability extends Simulation{

    setUp(
      OtusScenario()
        .inject(
          rampUsersPerSec(0).to(5)
        .during(30),
        constantUsersPerSec(5)
          .during(3600)))
      .protocols(otus.httpProtocol)
      .assertions(forAll.failedRequests.percent.lte(5))
      .assertions(forAll.responseTime.max.lt(3000))
}

