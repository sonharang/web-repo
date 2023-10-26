// module.js
import{friendInfo} from './friend.js';

import{cal}from '../todo/calendar2obj.js';


const friend = {
	name : 'Hwang',
	phone : '010-1234-5678',
	address : '대구 중구 200',
	showInfo : function(){
		return `${this.name}`;
	}
}

console.log(friend.showInfo());
console.log(friendInfo(friend));

cal.showCalendar();