import json
import requests
import time
import os

import fee

clearConsole = lambda: os.system('cls' if os.name in ('nt', 'dos') else 'clear')


BASE_URL = 'https://api.wazirx.com/sapi/v1/ticker/24hr'


with open('rates.json', 'w') as op_file:
	data = fee.tickers
	index = 0
	total = len(data)

	all_tokens = [{
    "name": fee.USDT['name'],
    "token": fee.USDT['type'],
    "minWithdrawAmount": float(fee.USDT['minWithdrawAmount']),
    "withdrawFee": float(fee.USDT['withdrawFee'])
	}]

	print('\nFetching USDT values\n')


	while len(data) > 0:
		ticker = data.pop()
		raw = requests.get(BASE_URL, {'symbol': ticker['type'].lower() + 'usdt'})
		res = raw.json()

		try:
			last_price = float(res['lastPrice'])
			all_tokens.append({
				'name': ticker['name'],
				'token': ticker['type'],
				'minWithdrawAmount': round(float(ticker['minWithdrawAmount']) * last_price, 5),
				'withdrawFee': round(float(ticker['withdrawFee']) * last_price, 5)
			})
			index+=1
		except:
			print('warning: ', res)
			data.append(ticker)
			time.sleep(0.5)
		finally:
			clearConsole()
			print(f'Progress {round(index / total * 100, 2)} %')

	all_tokens.sort(key=lambda x: x['withdrawFee'])

	op_file.write(json.dumps(all_tokens))

	show_top = len(all_tokens) if len(all_tokens) < 5 else 5

	clearConsole()
	print(f'Top {show_top} cryptos with minimum fee are:\n')
	for i in range(show_top):
		print(f"{all_tokens[i]['name']}({all_tokens[i]['token']}) withdraw fee {all_tokens[i]['withdrawFee']} USDT minimum amount {all_tokens[i]['minWithdrawAmount']} USDT")


print('\n\nFor more information check "rates.json"')