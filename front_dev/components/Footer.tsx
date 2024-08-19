import React from 'react'

import '@/styles/footer.css'

function Footer() {
  return (
    <footer>
      <h1 className="logo text-white">㈜글로브포인트</h1>
      <p className="add text-white">
        경기도 고양시 덕양구 삼원로 83, 광양프런티어밸리 6차 111호 (10550)
      </p>
      <ul className="info-list text-white">
        <li>
          {/* <img src="assets\img\icon\ic-tell.png" alt="전화"> */}
          031-911-0601
        </li>
        <li>
          {/* <img src="assets\img\icon\ic-fax.png" alt="팩스"> */}
          031-922-0602
        </li>
        <li>
          {/* <img src="assets\img\icon\ic-mail.png" alt="메일"> */}
          gpsales@globepoint.co.kr
        </li>
      </ul>
      <p className="copy">
        Copyrights ⓒ 2019 Globepoint Inc. All rights reserved.
      </p>
    </footer>
  )
}

export default Footer
