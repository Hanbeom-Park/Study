##### bind

------

- setTimeout 객체에서 분리된 user.sayHi만 전달이 된다.

```javascript
let user = {
  firstName: "John",
  sayHi() {
    console.log(`hello, ${this.firstName}!`);
  },
};
setTimeout(user.sayHi, 1000);//hello undefined!
```

- func.bind의 경우 this가 user로 고정되어서 할당된다.

```javascript
let user = {
  firstName: "John"
};

function func() {
  alert(this.firstName);
}

let funcUser = func.bind(user);
funcUser(); // John

let say=user.say.bind(user);//
```

- partial application 적용 가능

```javascript
function mul(a, b) {
  return a * b;
}

let double = mul.bind(null, 2);

alert( double(3) ); // = mul(2, 3) = 6
```



> 출처 : https://ko.javascript.info/bind
