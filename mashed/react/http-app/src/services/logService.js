import * as Sentry from "@sentry/react";
import {Integrations} from "@sentry/tracing";

function init() {
  Sentry.init({
    dsn: "https://7a45fb25ac4f4345ad535c258e41fb59@o756006.ingest.sentry.io/5792103",
    integrations: [new Integrations.BrowserTracing()],
    tracesSampleRate: 1.0,
  });
}

function log(error) {
  console.log("captured");
  Sentry.captureException(error);
}

export default {
  init, log
}