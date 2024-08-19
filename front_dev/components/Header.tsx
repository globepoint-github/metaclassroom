import React from 'react'

import '@/styles/header.css'

import Image from 'next/image'
import { IconLogo, IcNav, IcUser } from '@/public/icons'

function Header() {
  return (
    <header className="bg-white">
      <div className="left-area bg-white">
        <h1 className="logo">
          <Image src={IconLogo} alt="메타클래스룸" />
        </h1>
        <div className="nav-area">
          <ul className="main-nav">
            <li>
              콘텐츠
              <ul className="depth2">
                <li>
                  마이맵
                  <ul className="depth3">
                    <li>VRWARE Edu School</li>
                    <li>METAWARE Edu</li>
                  </ul>
                </li>
                <li>오브젝트</li>
                <li>수업자료</li>
                <li>즐겨찾기</li>
              </ul>
            </li>
            <li>
              학습관리
              <ul className="depth2">
                <li>학교 시간표</li>
                <li>학급 게시판</li>
                <li>
                  학급관리
                  <ul className="depth3">
                    <li>학생관리</li>
                    <li>모둠관리</li>
                    <li>출석관리</li>
                    <li>성적관리</li>
                    <li>과제관리</li>
                  </ul>
                </li>
                <li>수업 관리</li>
              </ul>
            </li>
            <li>
              스토어
              <ul className="depth2">
                <li>맵</li>
                <li>오브젝트</li>
                <li>수업자료</li>
                <li>좋아요</li>
              </ul>
            </li>
            <li>
              게시판
              <ul className="depth2">
                <li>공지사항</li>
                <li>FAQ 게시판</li>
                <li>Q&A 게시판</li>
                <li>매뉴얼</li>
              </ul>
            </li>
            <li>이벤트</li>
          </ul>
          <div className="hamburger">
            <span />
            <span />
            <span />
          </div>
          <div className="nav-all">
            <ul className="all-depth2">
              <li>
                마이맵
                <Image src={IcNav} alt="네비게이션" />
                <ul className="all-depth3">
                  <li>VRWARE Edu School</li>
                  <li>METAWARE Edu</li>
                </ul>
              </li>
              <li>
                오브젝트
                <Image src={IcNav} alt="네비게이션" />
              </li>
              <li>
                수업자료
                <Image src={IcNav} alt="네비게이션" />
              </li>
              <li>
                즐겨찾기
                <Image src={IcNav} alt="네비게이션" />
              </li>
            </ul>
            <ul className="all-depth2">
              <li>
                마이맵
                <Image src={IcNav} alt="네비게이션" />
              </li>
              <li>
                오브젝트
                <Image src={IcNav} alt="네비게이션" />
              </li>
              <li>
                수업자료
                <Image src={IcNav} alt="네비게이션" />
              </li>
              <li>
                즐겨찾기
                <Image src={IcNav} alt="네비게이션" />
              </li>
            </ul>
            <ul className="all-depth2">
              <li>
                마이맵
                <Image src={IcNav} alt="네비게이션" />
              </li>
              <li>
                오브젝트
                <Image src={IcNav} alt="네비게이션" />
              </li>
              <li>
                수업자료
                <Image src={IcNav} alt="네비게이션" />
              </li>
              <li>
                즐겨찾기
                <Image src={IcNav} alt="네비게이션" />
              </li>
            </ul>
            <ul className="all-depth2">
              <li>
                마이맵
                <Image src={IcNav} alt="네비게이션" />
              </li>
              <li>
                오브젝트
                <Image src={IcNav} alt="네비게이션" />
              </li>
              <li>
                수업자료
                <Image src={IcNav} alt="네비게이션" />
              </li>
              <li>
                즐겨찾기
                <Image src={IcNav} alt="네비게이션" />
              </li>
            </ul>
          </div>
        </div>
      </div>
      <div className="head-etc">
        {/* <Image src={IcHamburger} alt='hamburger' /> */}
        <div className="user-info">
          <div className="user-img">
            <Image src={IcUser} alt="프로필사진" />
          </div>
          <p>
            <span>장정원</span>님 환영합니다!
          </p>
        </div>
        <ul className="login-btn">
          <li>내 정보</li>
          <li>로그아웃</li>
        </ul>
      </div>
    </header>
  )
}

export default Header
