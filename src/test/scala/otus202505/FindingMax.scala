package otus202505

import io.gatling.core.Predef.{Simulation, _}

import scala.concurrent.duration.DurationInt

class FindingMax extends Simulation{

  setUp(OtusScenario()
    .inject(incrementUsersPerSec(1)
      .times(6)
      .eachLevelLasting(120)
      .separatedByRampsLasting(20)
      .startingFrom(1)))
    .maxDuration(40.minutes)
    .protocols(otus.httpProtocol)
    .assertions(forAll.failedRequests.percent.lte(5))
    .assertions(forAll.responseTime.max.lt(3000))
}

