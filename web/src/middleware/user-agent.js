export default function (context) {
  // 컨텍스트에 userAgent 프로퍼티를 추가합니다. (`data`와 `fetch`에서 사용 가능)
  context.userAgent = process.server ? context.req.headers['user-agent'] : navigator.userAgent
}
