import requests

print("Fetching withdrawable currencies\n")

raw = requests.get('https://x.wazirx.com/api/v2/market-status')

USDT = None
tickers = []

for ticker in raw.json()['assets']:
	if ticker['deposit'] == 'enabled' and ticker['withdrawal'] == 'enabled' and ticker['category'] != 'fiat':
		if ticker['type'] == 'usdt':
			USDT = ticker
		else:
			tickers.append(ticker)
